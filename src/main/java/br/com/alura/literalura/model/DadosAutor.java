package br.com.alura.literalura.model;

import java.util.List;

public record DadosAutor(String nome, int anoNascimento, int anoFalecimento, List<Livro> livrosEscritos) {
}
