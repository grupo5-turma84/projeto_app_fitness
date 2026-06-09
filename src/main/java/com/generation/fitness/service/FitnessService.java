package com.generation.fitness.service;

import org.springframework.stereotype.Service;

@Service
public class FitnessService {

    public String calcularEClassificarIMC(double peso, double altura) {
        if (altura <= 0) {
            return "Altura inválida";
        }
        
        double imc = peso / (altura * altura);
        
        if (imc < 18.5) {
            return "IMC: " + String.format("%.2f", imc) + " - Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "IMC: " + String.format("%.2f", imc) + " - Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "IMC: " + String.format("%.2f", imc) + " - Sobrepeso";
        } else {
            return "IMC: " + String.format("%.2f", imc) + " - Obesidade";
        }
    }
}