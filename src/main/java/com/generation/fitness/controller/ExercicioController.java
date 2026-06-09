package com.generation.fitness.controller;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.generation.fitness.model.Exercicio;
import com.generation.fitness.repository.ExercicioRepository;
import com.generation.fitness.repository.CategoriaRepository;
import com.generation.fitness.service.FitnessService;

@RestController
@RequestMapping("/exercicios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExercicioController {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FitnessService fitnessService;

    // Rota da Funcionalidade Especial via Parâmetros de URL
    @GetMapping("/imc")
    public ResponseEntity<String> obterImc(@RequestParam double peso, @RequestParam double altura) {
        String resultado = fitnessService.calcularEClassificarIMC(peso, altura);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<List<Exercicio>> getAll() {
        return ResponseEntity.ok(exercicioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> getById(@PathVariable Long id) {
        return exercicioRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Exercicio>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(exercicioRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Exercicio> post(@Valid @RequestBody Exercicio exercicio) {
        if (exercicio.getCategoria() != null && exercicio.getCategoria().getId() != null) {
            return categoriaRepository.findById(exercicio.getCategoria().getId())
                    .map(categoria -> {
                        exercicio.setCategoria(categoria);
                        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioRepository.save(exercicio));
                    })
                    .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    public ResponseEntity<Exercicio> put(@Valid @RequestBody Exercicio exercicio) {
        if (exercicioRepository.existsById(exercicio.getId())) {
            if (exercicio.getCategoria() != null && exercicio.getCategoria().getId() != null) {
                return categoriaRepository.findById(exercicio.getCategoria().getId())
                        .map(categoria -> {
                            exercicio.setCategoria(categoria);
                            return ResponseEntity.status(HttpStatus.OK).body(exercicioRepository.save(exercicio));
                        })
                        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        if (exercicio.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        exercicioRepository.deleteById(id);
    }
}