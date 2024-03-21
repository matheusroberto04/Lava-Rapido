package com.example.lavarapidoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lavarapidoapi.model.Agendamento;
import com.example.lavarapidoapi.repository.AgendamentoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoRepository repository;

    @PostMapping
    public Agendamento create(@RequestBody @Valid Agendamento agendamento){
        return repository.save(agendamento);
    }
    
}
