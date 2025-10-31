package com.bibliotech.api.API.controllers;

import com.bibliotech.api.API.emprestimos.*;
import com.bibliotech.api.API.pessoas.*;
import com.bibliotech.api.API.emprestimos.DadosCadastroEmprestimo;
import com.bibliotech.api.API.livros.*;
import com.bibliotech.api.API.pessoas.PessoaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

    @RequestMapping("/emprestimos")
    @RestController
    public class EmprestimoController {
        @Autowired
        private EmprestimoRepositorio emprestimoRepositorio;
        @Autowired
        private LivroRepositorio livroRepositorio;
        @Autowired
        private PessoaRepositorio pessoaRepositorio;
        @PostMapping("/inserir")
        @Transactional
        public ResponseEntity<?> inserir(@RequestBody DadosCadastroEmprestimo dados) {
            if(!livroRepositorio.existsById(dados.livro_id())) {
                return ResponseEntity.notFound().build();
            }
            if (!pessoaRepositorio.existsById((dados.pessoa_id()))) {
                return ResponseEntity.notFound().build();
            }
            Livro livro = livroRepositorio.getReferenceById(dados.livro_id());
            Pessoa pessoa = pessoaRepositorio.getReferenceById(dados.pessoa_id());
            Emprestimo emprestimo = emprestimoRepositorio.save(new Emprestimo(dados, livro, pessoa));
            Long id = emprestimo.getId();
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();
            return ResponseEntity.created(uri).build();
        }

        @GetMapping("/listar")
        public ResponseEntity<?> listar() {
            var lista = emprestimoRepositorio.findAll().stream().map(DadosListagemEmprestimo::new).toList();
            return ResponseEntity.ok(lista);
        }

        @PutMapping("/alterar")
        @Transactional
        public ResponseEntity<?> alterar(@RequestBody DadosAlteracaoEmprestimo dados) {
            if (!emprestimoRepositorio.existsById(dados.id())) {
                return ResponseEntity.notFound().build();
            }
            if(!pessoaRepositorio.existsById(dados.pessoa_id())) {
                return ResponseEntity.notFound().build();
            }
            Pessoa pessoa = pessoaRepositorio.getReferenceById(dados.pessoa_id());
            Livro livro = livroRepositorio.getReferenceById(dados.livro_id());
            Emprestimo emprestimo = emprestimoRepositorio.getReferenceById(dados.id());
            emprestimo.atualizaInformacoes(dados, livro, pessoa);
            return ResponseEntity.ok(dados);
        }

        @DeleteMapping("/excluir{id}")
        @Transactional
        public ResponseEntity<?> excluir(@PathVariable Long id) {
            if (!emprestimoRepositorio.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            emprestimoRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

