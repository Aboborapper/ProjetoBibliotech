package com.bibliotech.api.API.controllers;

import com.bibliotech.api.API.autores.Autor;
import com.bibliotech.api.API.autores.AutorRepositorio;
import com.bibliotech.api.API.generos.Genero;
import com.bibliotech.api.API.generos.GeneroRepositorio;
import com.bibliotech.api.API.livros.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


    @RequestMapping("/livros")
    @RestController
    public class LivroController {
        @Autowired
        private LivroRepositorio livroRepositorio;
        @Autowired
        private AutorRepositorio autorRepositorio;
        @Autowired
        private GeneroRepositorio generoRepositorio;
        @PostMapping("/inserir")
        @Transactional
        public ResponseEntity<?> inserir(@RequestBody DadosCadastroLivro dados) {
            if(!autorRepositorio.existsById(dados.autor_id())) {
                return ResponseEntity.notFound().build();
            }
            if (!generoRepositorio.existsById((dados.genero_id()))) {
                return ResponseEntity.notFound().build();
            }
            Autor autor = autorRepositorio.getReferenceById(dados.autor_id());
            Genero genero = generoRepositorio.getReferenceById(dados.genero_id());
            Livro livro = livroRepositorio.save(new Livro(dados,autor,genero));
            Long id = livro.getId();
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();
            return ResponseEntity.created(uri).build();
        }

        @GetMapping("/listar")
        public ResponseEntity<?> listar() {
            var lista = livroRepositorio.findAll().stream().map(DadosListagemLivro::new).toList();
            return ResponseEntity.ok(lista);
        }

        @PutMapping("/alterar")
        @Transactional
        public ResponseEntity<?> alterar(@RequestBody DadosAlteracaoLivro dados) {
            if (!livroRepositorio.existsById(dados.id())) {
                return ResponseEntity.notFound().build();
            }
            if(!autorRepositorio.existsById(dados.autor_id())) {
                return ResponseEntity.notFound().build();
            }
            if (!generoRepositorio.existsById((dados.genero_id()))) {
                return ResponseEntity.notFound().build();
            }
            Autor autor = autorRepositorio.getReferenceById(dados.autor_id());
            Genero genero = generoRepositorio.getReferenceById(dados.genero_id());
            Livro livro = livroRepositorio.getReferenceById(dados.id());
            livro.atualizaInformacoes(dados,autor,genero);
            return ResponseEntity.ok(dados);
        }

        @DeleteMapping("/excluit{id}")
        @Transactional
        public ResponseEntity<?> excluir(@PathVariable Long id) {
            if (!livroRepositorio.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            livroRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

