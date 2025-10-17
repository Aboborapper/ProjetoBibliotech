package com.bibliotech.api.API.livros;

public record DadosCadastroLivro(String titulo, String isbn, int ano_publicacao, String foto, Long genero_id, Long autor_id) {
}
