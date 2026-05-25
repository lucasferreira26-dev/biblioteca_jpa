# 📚 Biblioteca JPA

Projeto desenvolvido para praticar **Java + JPA + Hibernate** com persistência de dados usando Maven.

Este projeto faz parte da minha evolução nos estudos de desenvolvimento backend com Java, com foco em modelagem de entidades, persistência em banco de dados e boas práticas com JPA.

---

## 🚀 Tecnologias utilizadas

- Java
- Maven
- JPA (Jakarta Persistence API)
- Hibernate
- Banco de dados relacional
- IntelliJ IDEA

---

## 📁 Estrutura do projeto

```bash
src/
 ├── main/
 │    ├── java/com/lucas/biblioteca/
 │    │     ├── Categoria.java
 │    │     ├── Livro.java
 │    │     └── Main.java
 │    │
 │    └── resources/
 │          └── META-INF/
 │                └── persistence.xml
```

---

## 📌 Objetivo do projeto

O objetivo deste projeto é praticar conceitos fundamentais de persistência com JPA, como:

- mapeamento de entidades com `@Entity`
- chave primária com `@Id`
- geração automática de ID
- relacionamento entre entidades
- configuração de unidade de persistência
- operações de persistência com `EntityManager`

---

## 🧠 Aprendizados

Durante o desenvolvimento deste projeto venho praticando:

- modelagem de entidades Java
- configuração do Hibernate com JPA
- persistência de objetos no banco de dados
- organização de projeto com Maven
- estruturação de aplicações Java backend

---

## ▶️ Como executar

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/biblioteca_jpa.git
```

Entre na pasta:

```bash
cd biblioteca_jpa
```

Execute com Maven:

```bash
mvn compile
mvn exec:java
```

Ou rode diretamente pela IDE.
