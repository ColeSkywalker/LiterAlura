package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="autor")
public class Autor {
    String nome;
    int anoNascimento;
    int anoFalecimento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Livro> livrosEscritos;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Autor() {

    }

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
        this.livrosEscritos = new ArrayList<>();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        String livrosRegistrados = livrosEscritos.stream()
                .map(Livro::getTitulo)
                .collect(Collectors.joining("\n"));
        return String.format("""
                --------------------------
                Nome do autor: %s
                Ano de nascimento: %s
                Ano do falecimento: %s
                Livros: %s
                --------------------------
                """ , nome,
                anoNascimento,
                anoFalecimento, livrosRegistrados);
    }
}
