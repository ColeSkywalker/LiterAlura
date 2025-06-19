# LiterAlura 📚

Projeto desenvolvido durante um bootcamp da Alura + ORACLE ONE. Trata-se de uma aplicação console em Java com Spring Boot que consome dados da API [Gutendex](https://gutendex.com/), armazena livros e autores no banco de dados e permite consultas diversas via terminal.

## 🔧 Tecnologias utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Jackson** (para desserialização JSON)
- **API Gutendex** (https://gutendex.com/)

## 📁 Estrutura do projeto

- `model`: entidades JPA (`Livro`, `Autor`)
- `repository`: interfaces para acesso ao banco (`JpaRepository`)
- `service`: conversão de JSON para objetos Java
- `search`: lógicas de consulta e persistência de dados da API
- `http`: client HTTP genérico
- `principal`: classe principal com menu de interação

## 🚀 Funcionalidades atuais

- Buscar livros pelo título (com acesso à API e persistência no banco)
- Listar livros registrados localmente
- Listar autores registrados
- Listar autores que estavam vivos em um determinado ano
- Listar livros por idioma (inglês, português, espanhol)

