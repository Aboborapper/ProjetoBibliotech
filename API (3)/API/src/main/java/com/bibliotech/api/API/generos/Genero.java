package com.bibliotech.api.API.generos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "Genero")
@Entity(name = "generos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Genero {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    public Genero(DadosCadastroGenero dados) { this.nome = dados.nome(); }
    public void atualizaInformacoes(DadosAlteracaoGenero dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();

        }
        }
    }

