package com.bibliotech.api.API.generos;

public record DadosListagemGenero(Long id, String nome) {
    public DadosListagemGenero(Genero dados) {
        this(dados.getId(), dados.getNome());
    }
}
