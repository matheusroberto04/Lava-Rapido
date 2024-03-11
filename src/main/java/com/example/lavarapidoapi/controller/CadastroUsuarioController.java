package com.example.lavarapidoapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lavarapidoapi.model.CadastroUsuario;

@RestController
@RequestMapping("cadastrousuario")
public class CadastroUsuarioController{
    //Criacao de uma lista para armazenar dados de cadastro!
    Logger log = LoggerFactory.getLogger(getClass());

    List<CadastroUsuario> repository = new ArrayList<>();
    //Endpoint que retorna os cadastros existentes
    @GetMapping
    public List<CadastroUsuario> index(){
        return repository;
    }
    //Endpoint para criacao de um novo cadastro   
    @PostMapping
    public ResponseEntity<CadastroUsuario> create(@RequestBody CadastroUsuario cadastro){
        log.info("Cadastrando cliente: {}", cadastro);
        repository.add(cadastro);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cadastro);
    }
    //Busca um cadastro por ID
    @GetMapping("{id}")
    public ResponseEntity<CadastroUsuario> get(@PathVariable Long id){
        log.info("Buscar por id: {}", id);

        var optionalCadastro = buscarCadastroPorId(id);

        if (optionalCadastro.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(optionalCadastro.get());
    }
    //Exclui um cadastro pelo ID
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando cadastro {}", id);

        var optionalCadastro = buscarCadastroPorId(id);

        if (optionalCadastro.isEmpty())
            return ResponseEntity.notFound().build();
        repository.remove(optionalCadastro.get());

        return ResponseEntity.noContent().build();

    }
    //Atualiza um cadastro existente
    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody CadastroUsuario cadastro) {
        log.info("Atualizando cadastro pelo id {} para {}", id, cadastro);
        
        var optionalCadastro = buscarCadastroPorId(id);

        if (optionalCadastro.isEmpty())
            return ResponseEntity.notFound().build();

        var cadastroEncontrado = optionalCadastro.get();

        var cadastroAtualizado = new CadastroUsuario(id,
        cadastro.email(),
        cadastro.senha(),
        cadastro.nome_completo());

        repository.remove(cadastroEncontrado);
        repository.add(cadastroAtualizado);

        return ResponseEntity.ok().body(cadastroAtualizado);
    }
    //Metodo privado para que se busque um cadastro pelo ID, sendo utilizado somente por funcionarios do lava-rapido
    private Optional<CadastroUsuario> buscarCadastroPorId(Long id) {
        var optionalCadastro = repository
                .stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
        return optionalCadastro;
    }
    

}