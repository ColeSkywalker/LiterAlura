package br.com.alura.literalura.model;

import java.util.List;

public class Autor {
    String nome;
    int anoNascimento;
    int anoFalecimento;
    List<Livro> livrosEscritos;

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivrosEscritos() {
        return livrosEscritos;
    }

    public void setLivrosEscritos(List<Livro> livrosEscritos) {
        this.livrosEscritos = livrosEscritos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor(DadosAutor dadosAutor) {
        this.nome = dadosAutor.nomeAutor();
        this.anoNascimento = dadosAutor.anoNascimento();
        this.anoFalecimento = dadosAutor.anoFalecimento();
        this.livrosEscritos = dadosAutor.livrosEscritos(); // CONECTAR AO DB
    }
}
