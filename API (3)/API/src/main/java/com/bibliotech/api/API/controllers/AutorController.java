package com.bibliotech.api.API.controllers;

import com.bibliotech.api.API.autores.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RequestMapping("/autores")
@RestController
public class AutorController {
    @Autowired
    private AutorRepositorio autorRepositorio;

    @PostMapping("/inserir")
    @Transactional
    public ResponseEntity<?> inserir(@RequestBody DadosCadastroAutor dados) {
        Autor autor = autorRepositorio.save(new Autor(dados));
        Long id = autor.getId();
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        var lista = autorRepositorio.findAll().stream().map(DadosListagemAutor::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/alterar")
    @Transactional
    public ResponseEntity<?> alterar(@RequestBody DadosAlteracaoAutor dados) {
        if (!autorRepositorio.existsById(dados.id())){

                return ResponseEntity.notFound().build();
        }
            Autor autor = autorRepositorio.getReferenceById(dados.id());
            autor.atualizaInformacoes(dados);
            return ResponseEntity.ok(dados);
        }


    @DeleteMapping("/excluir/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        if (!autorRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        autorRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
