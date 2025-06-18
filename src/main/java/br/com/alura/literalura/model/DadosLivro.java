package br.com.alura.literalura.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo, @JsonAlias("authors") String autor,
                         @JsonAlias("languages") String idiomaOriginal, @JsonAlias("download_count") String numeroDownloads){
}
