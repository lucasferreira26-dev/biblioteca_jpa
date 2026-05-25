package com.lucas.biblioteca;

import jakarta.persistence.*;

@Entity
@Table (name = "LIVROS")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIVRO_ID")
    private Long id;

    @Column (name = "TITULO", nullable = false)
    private String titulo;

    @Column (name = "AUTOR", nullable = false)
    private String autor;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "CATEGORIA_ID")
    private Categoria categoriaId;

    public Livro() {
    }


    public Livro(String titulo, String autor, String isbn, Categoria categoriaId) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }
}
