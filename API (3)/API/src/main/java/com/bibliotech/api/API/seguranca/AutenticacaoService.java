package com.bibliotech.api.API.seguranca;

import com.bibliotech.api.API.pessoas.Pessoa;
import com.bibliotech.api.API.pessoas.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AutenticacaoService implements UserDetailsService{
    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    public UserDetails loadUserByUsername(String nome, String telefone, String email) throws UsernameNotFoundException {
        return pessoaRepositorio.findByPessoa(nome,telefone,email)
                .map(pessoa -> new User(pessoa.getNome(), pessoa.getNome(), Collections.emptyList()))
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}

