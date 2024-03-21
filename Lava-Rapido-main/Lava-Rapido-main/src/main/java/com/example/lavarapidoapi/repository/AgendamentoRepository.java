package com.example.lavarapidoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lavarapidoapi.model.Agendamento;
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long>{
}
