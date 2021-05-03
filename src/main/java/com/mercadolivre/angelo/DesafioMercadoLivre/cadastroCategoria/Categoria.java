package com.mercadolivre.angelo.DesafioMercadoLivre.cadastroCategoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @ManyToOne
    private Categoria mae;

    @Deprecated
    public Categoria(){}

    public Categoria(@NotNull String nome){
        this.nome=nome;
    }
    public Categoria(@NotNull String nome, Categoria mae){
        this.nome=nome;
        this.mae= mae;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getMae() {
        return mae;
    }
}
