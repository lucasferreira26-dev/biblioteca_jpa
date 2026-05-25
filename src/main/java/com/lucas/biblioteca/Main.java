package com.lucas.biblioteca;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        // INICIALIZANDO UNIDADE DE PERSISTÊNCIA
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Biblioteca");

        // CRIANDO ENTIDADES E PERSISTINDO OS DADOS
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Categoria> categoriasLivros = Arrays.asList(
                new Categoria("Romantasy"),
                new Categoria("Thriller Psicológico e Suspense"),
                new Categoria("Desenvolvimento Pessoal e Produtividade"),
                new Categoria("Romance Contemporâneo"),
                new Categoria("Ficção Científica e Distopia")
        );
        categoriasLivros.forEach(em::persist);

        List<Livro> livros = Arrays.asList(
                new Livro("Quarta Asa (Fourth Wing)", "Rebecca Yarros", "978-6555359947", categoriasLivros.get(0)),
                new Livro("Chama de Ferro (Iron Flame)", "Rebecca Yarros", "978-8542225136", categoriasLivros.get(0)),
                new Livro("Corte de Espinhos e Rosas", "Sarah J. Maas", "978-8501104335", categoriasLivros.get(0)),
                new Livro("Corte de Névoa e Fúria", "Sarah J. Maas", "978-8501076236", categoriasLivros.get(0)),
                new Livro("Trono de Vidro", "Sarah J. Maas", "978-8501401342", categoriasLivros.get(0)),
                new Livro("O Príncipe Cruel", "Holly Black", "978-8501115539", categoriasLivros.get(0)),
                new Livro("A Empregada", "Freida McFadden", "978-6555606409", categoriasLivros.get(1)),
                new Livro("O Segredo da Empregada", "Freida McFadden", "978-6555608755", categoriasLivros.get(1)),
                new Livro("A Paciente Silenciosa", "Alex Michaelides", "978-8501115324", categoriasLivros.get(1)),
                new Livro("O Homem de Giz", "C.J. Tudor", "978-8551002711", categoriasLivros.get(1)),
                new Livro("Hábitos Atômicos", "James Clear", "978-8543108667", categoriasLivros.get(2)),
                new Livro("O Poder do Hábito", "Charles Duhigg", "978-8511002263", categoriasLivros.get(2)),
                new Livro("Psicologia Financeira", "Morgan Housel", "978-6555641219", categoriasLivros.get(2)),
                new Livro("Mais Esperto que o Diabo", "Napoleon Hill", "978-8563137258", categoriasLivros.get(2)),
                new Livro("O Milagre da Manhã", "Hal Elrod", "978-8520442371", categoriasLivros.get(2)),
                new Livro("É Assim que Acaba", "Colleen Hoover", "978-8501101037", categoriasLivros.get(3)),
                new Livro("É Assim que Começa", "Colleen Hoover", "978-8501504715", categoriasLivros.get(3)),
                new Livro("Uma Longa Viagem a um Pequeno Planeta Hostil", "Becky Chambers", "978-8592503253", categoriasLivros.get(3)),
                new Livro("Melhor do que nos Filmes", "Lynn Painter", "978-6555605914", categoriasLivros.get(3)),
                new Livro("Duna", "Frank Herbert", "978-8576573005", categoriasLivros.get(4)),
                new Livro("Fogo e Sangue", "George R.R. Martin", "978-8556510761", categoriasLivros.get(4)),
                new Livro("Matéria Escura", "Blake Crouch", "978-8580579628", categoriasLivros.get(4)),
                new Livro("1984", "George Orwell", "978-8535914849", categoriasLivros.get(4))
        );
        livros.forEach(em::persist);

        tx.commit();
        em.close();

        // PRIMEIRA QUERY: MOSTRAR TODOS OS LIVROS
        EntityManager newEm = emf.createEntityManager();
        EntityTransaction newTx = newEm.getTransaction();
        newTx.begin();

        List<String> todosOsLivros = newEm
                .createQuery("select l.titulo from Livro l order by l.titulo", String.class)
                .getResultList();

        System.out.println("Todos os titulos: ");

        todosOsLivros.forEach(System.out::println);

        newTx.commit();
        newEm.close();

        // SEGUNDA QUERY: BUSCAR LIVROS POR CATEGORIA
        EntityManager outraEm = emf.createEntityManager();
        EntityTransaction outraTx = outraEm.getTransaction();
        outraTx.begin();

        List<String> categoriaRomantasy = outraEm
                .createQuery("select l.titulo from Livro l where l.categoriaId.nomeCategoria = 'Romantasy'", String.class)
                .getResultList();

        System.out.println("Livros da Categoria Romantasy: ");

        categoriaRomantasy.forEach(System.out::println);

        outraTx.commit();
        outraEm.close();

        // TERCEIRA QUERY: ATUALIZAR UM ELEMENTO DA LISTA DE LIVROS
        EntityManager ultimaEm = emf.createEntityManager();
        EntityTransaction ultimaTx = ultimaEm.getTransaction();
        ultimaTx.begin();

        Livro livro = ultimaEm.find(Livro.class, 2L);

        livro.setTitulo("Espada de Vidro");
        livro.setAutor("Victoria Aveyard");
        livro.setIsbn("978-8557170179");



        ultimaTx.commit();
        ultimaEm.close();

        emf.close();
    }
}
