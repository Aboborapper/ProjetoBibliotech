package com.bibliotech.api.API.reservas;

import com.bibliotech.api.API.livros.Livro;
import com.bibliotech.api.API.pessoas.Pessoa;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Reserva")
@Entity(name = "Reservas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()

public class Reserva {
    @Id
    @GeneratedValue
    private Long id;
    private int data_reserva;
    private int data_validade;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Reserva(DadosCadastroReserva dados, Livro livro, Pessoa pessoa) {
        this.data_reserva = dados.data_reserva();
        this.data_validade = dados.data_validade();
        this.pessoa = pessoa;
        this.livro = livro;

    }

    public void atualizaInformacoes(DadosAlteracaoReserva dados, Livro livro, Pessoa pessoa) {
        if (dados.data_reserva() != 0) {
            this.data_reserva = dados.data_reserva();
        }
        if (dados.data_validade() != 0) {
            this.data_validade = dados.data_validade();
        }
        if (pessoa != null) {
            this.pessoa = pessoa;
        }
        if (livro != null) {
            this.livro = livro;
        }
    }
}
