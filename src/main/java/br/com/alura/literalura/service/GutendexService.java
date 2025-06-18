package br.com.alura.literalura.service;
import br.com.alura.literalura.search.IBuscador;

public class GutendexService {
    private static final String BASE_URL = "https://gutendex.com/books";

    public <T> T buscar(String termoDeBusca, IBuscador buscador) {
        return buscador.buscar(termoDeBusca);
    }


}
