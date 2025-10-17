package com.bibliotech.api.API.emprestimos;

public record DadosListagemEmprestimo(int data_emprestimo, int data_devolucao, Long livro_id, Long pessoa_id, String livro_nome, String nome_pessoa) {
    public DadosListagemEmprestimo(Emprestimo dados) {
        this(dados.getId(), dados.getData_devolucao(), dados.getData_emprestimo(), dados.getPessoa().getId(), dados.getPessoa().getNome(), dados.getLivro().getId(), dados.getLivro().getTitulo());
    }

}
