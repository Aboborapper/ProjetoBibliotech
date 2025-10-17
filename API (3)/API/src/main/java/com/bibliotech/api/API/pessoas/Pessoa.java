package com.bibliotech.api.API.pessoas;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Pessoa")
@Entity(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(DadosCadastroPessoa dados) {this.nome = dados.nome(); this.email = dados.email(); this.telefone = dados.telefone();}
    public void atualizaInformacoes(DadosAlteracaoPessoa dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }
}
