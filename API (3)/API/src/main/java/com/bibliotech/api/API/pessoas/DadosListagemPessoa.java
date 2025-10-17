package com.bibliotech.api.API.pessoas;

public record DadosListagemPessoa(Long id, String nome, String telefone, String email) {
    public DadosListagemPessoa(Pessoa dados) {
        this(dados.getId(), dados.getNome(), dados.getTelefone(), dados.getEmail());
    }
}
