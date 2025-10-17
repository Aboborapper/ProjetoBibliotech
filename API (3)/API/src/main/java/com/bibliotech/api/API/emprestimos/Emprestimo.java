package com.bibliotech.api.API.emprestimos;

import com.bibliotech.api.API.autores.Autor;
import com.bibliotech.api.API.generos.Genero;
import com.bibliotech.api.API.livros.DadosCadastroLivro;
import com.bibliotech.api.API.livros.Livro;
import com.bibliotech.api.API.pessoas.Pessoa;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Emprestimo")
@Entity(name = "Emprestimos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Emprestimo {
    @Id
    @GeneratedValue
    private Long id;
    private int data_emprestimo;
    private int data_devolucao;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Emprestimo(DadosCadastroEmprestimo dados, Livro livro, Pessoa pessoa) {
        this.data_emprestimo = dados.data_emprestimo();
        this.data_devolucao = dados.data_devolucao();
        this.pessoa = pessoa;
        this.livro = livro;

    }

    public void atualizaInformacoes(DadosAlteracaoEmprestimo dados, Livro livro, Pessoa pessoa) {
        if (dados.data_emprestimo() != 0) {
            this.data_emprestimo = dados.data_emprestimo();
        }
        if (dados.data_devolucao() != 0) {
            this.data_devolucao = dados.data_devolucao();
        }
        if (pessoa != null) {
            this.pessoa = pessoa;
        }
        if (livro != null) {
            this.livro = livro;
        }
    }

}
