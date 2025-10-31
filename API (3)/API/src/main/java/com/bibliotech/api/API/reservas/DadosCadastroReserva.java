package com.bibliotech.api.API.reservas;

public record DadosCadastroReserva(int data_reserva, int data_validade, Long livro_id, Long pessoa_id) {
}
