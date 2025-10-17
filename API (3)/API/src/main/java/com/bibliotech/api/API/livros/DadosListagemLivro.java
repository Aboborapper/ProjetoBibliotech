package com.bibliotech.api.API.livros;

public record DadosListagemLivro(String titulo, String isbn, int ano_publicacao, String foto, Long genero_id, Long autor_id, String nome_genero, String nome_autor) {
    public DadosListagemLivro(Livro dados) {
        this(dados.getTitulo(), dados.getIsbn(), dados.getAno_publicacao(), dados.getFoto(), dados.getGenero().getId(), dados.getAutor().getId(), dados.getGenero().getNome(), dados.getAutor().getNome());
    }
}
