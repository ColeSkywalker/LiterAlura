package br.com.alura.literalura.search;
import br.com.alura.literalura.http.HttpClientHelper;
import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.service.ConverteDados;

public class BuscarLivro implements IBuscador {
    private static final String BASE_URL = "https://gutendex.com/books";
    ConverteDados conversor = new ConverteDados();

    @Override
    public DadosLivro buscar(String termoDeBusca) {
        String url = BASE_URL + "?search=" + termoDeBusca.replace(" ", "+");

        var json = HttpClientHelper.get(url);
        DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);
        return dadosLivro;
    }
}
