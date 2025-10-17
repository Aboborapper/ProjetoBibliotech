package com.bibliotech.api.API.emprestimos;

public record DadosCadastroEmprestimo(int data_emprestimo, int data_devolucao, Long livro_id, Long pessoa_id) {
}
