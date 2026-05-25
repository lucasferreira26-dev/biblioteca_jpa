package com.lucas.biblioteca;

import jakarta.persistence.*;

@Entity
@Table (name = "CATEGORIAS_DE_LIVROS")
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CATEGORIA_ID")
    private Long id;

    @Column (name = "CATEGORIA", unique = true, nullable = false)
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
