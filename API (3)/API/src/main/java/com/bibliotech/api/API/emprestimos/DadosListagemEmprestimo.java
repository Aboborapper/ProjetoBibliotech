package com.bibliotech.api.API.emprestimos;

public record DadosListagemEmprestimo(int data_emprestimo, int data_devolucao, Long livro_id, Long pessoa_id, String livro_nome, String nome_pessoa) {
    public DadosListagemEmprestimo(Emprestimo dados) {
        this(
                dados.getData_emprestimo(),
                dados.getData_devolucao(),
                dados.getLivro().getId(),
                dados.getPessoa().getId(),
                dados.getLivro().getTitulo(),
                dados.getPessoa().getNome()
        );
    }

}
