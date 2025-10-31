package com.bibliotech.api.API.reservas;


public record DadosListagemReserva(int data_reserva, int data_validade, Long livro_id, Long pessoa_id, String livro_nome, String nome_pessoa) {
    public DadosListagemReserva(Reserva dados) {
        this(
                dados.getData_reserva(),
                dados.getData_validade(),
                dados.getLivro().getId(),
                dados.getPessoa().getId(),
                dados.getLivro().getTitulo(),
                dados.getPessoa().getNome()
        );
    }
}
