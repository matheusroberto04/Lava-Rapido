package com.example.lavarapidoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lavarapidoapi.model.CadastroUsuario;

public interface CadastroUsuarioRepository extends JpaRepository<CadastroUsuario, Long> {

}