package com.example.lavarapidoapi.model;

import java.util.Random;
public record CadastroUsuario (Long id, String nome_completo, String email, String senha){

    public CadastroUsuario(Long id, String nome_completo, String email, String senha){
        var key = (id != null) ? id : Math.abs( new Random().nextLong());
            this.id = key;
            this.nome_completo = nome_completo;
            this.email = email;
            this.senha = senha;
            
        }
}