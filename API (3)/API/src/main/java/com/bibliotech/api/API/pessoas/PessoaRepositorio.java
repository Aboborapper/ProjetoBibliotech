package com.bibliotech.api.API.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
    Optional<Pessoa> findByPessoa(String nome, String telefone, String email);
}