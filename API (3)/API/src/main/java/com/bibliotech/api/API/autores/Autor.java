package com.bibliotech.api.API.autores;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Autor")
@Entity(name = "autores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Autor(DadosCadastroAutor dados) {
        this.nome = dados.nome();
    }

    public void atualizaInformacoes(DadosAlteracaoAutor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

    }
}
