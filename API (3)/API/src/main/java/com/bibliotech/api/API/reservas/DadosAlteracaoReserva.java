package com.bibliotech.api.API.reservas;

public record DadosAlteracaoReserva(Long id, int data_reserva, int data_validade, Long livro_id, Long pessoa_id) {
}
