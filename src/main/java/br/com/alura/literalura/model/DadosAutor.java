package br.com.alura.literalura.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(@JsonAlias("name")String nomeAutor, @JsonAlias("birth_year")int anoNascimento, @JsonAlias("death_year")int anoFalecimento,
                         List<Livro> livrosEscritos) {
}
