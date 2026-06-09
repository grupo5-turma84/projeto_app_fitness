package com.generation.fitness.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.generation.fitness.model.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    public List<Exercicio> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}