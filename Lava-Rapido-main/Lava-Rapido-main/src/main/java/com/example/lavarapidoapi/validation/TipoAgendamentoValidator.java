package com.example.lavarapidoapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoAgendamentoValidator implements ConstraintValidator<TipoAgendamento, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("ENTRADA")|| value.equals("SAIDA");
    }

    
}
