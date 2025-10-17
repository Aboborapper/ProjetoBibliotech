package com.bibliotech.api.API.emprestimos;

public record DadosAlteracaoEmprestimo(Long id, int data_emprestimo, int data_devolucao, Long livro_id, Long pessoa_id) {
}
