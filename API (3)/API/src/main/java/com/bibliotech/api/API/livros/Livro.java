package com.bibliotech.api.API.livros;

import com.bibliotech.api.API.autores.Autor;
import com.bibliotech.api.API.generos.Genero;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Livro")
@Entity(name = "livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Livro {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String isbn;
    private int ano_publicacao;
    private String foto;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    public Livro(DadosCadastroLivro dados, Autor autor, Genero genero) {
        this.titulo = dados.titulo();
        this.foto = dados.foto();
        this.ano_publicacao = dados.ano_publicacao();
        this.isbn = dados.isbn();
        this.autor = autor;
        this.genero = genero;

    }


    public void atualizaInformacoes(DadosAlteracaoLivro dados, Autor autor, Genero genero) {
        if(dados.isbn() != null) {
            this.isbn = dados.isbn();
        }
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.foto() != null) {
            this.foto = dados.foto();
        }
        if(dados.ano_publicacao() != 0) {
            this.ano_publicacao = dados.ano_publicacao();
        }
        if (autor != null) {
            this.autor = autor;
        }
        if (genero != null) {
            this.genero = genero;
        }
    }

}
