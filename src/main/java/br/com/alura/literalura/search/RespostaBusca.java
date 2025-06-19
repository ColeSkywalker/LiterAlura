package br.com.alura.literalura.search;

import br.com.alura.literalura.model.DadosLivro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespostaBusca (@JsonAlias("results")List<DadosLivro> resultado){ // Record responsável pela desserialização do resultado da busca
}
