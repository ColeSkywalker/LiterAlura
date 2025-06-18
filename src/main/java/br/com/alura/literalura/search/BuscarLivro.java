package br.com.alura.literalura.search;
import br.com.alura.literalura.http.HttpClientHelper;
import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.service.ConverteDados;

import java.util.List;

public class BuscarLivro implements IBuscador {
    private static final String BASE_URL = "https://gutendex.com/books";
    ConverteDados conversor = new ConverteDados();


    @Override
    public  DadosLivro buscar(String termoDeBusca){
        String url = BASE_URL + "?search=" + termoDeBusca.replace(" ", "+");

        var json = HttpClientHelper.get(url);
        RespostaBusca respostaBusca = conversor.obterDados(json, RespostaBusca.class); // Converte todos os resultados da pesquisa em JSON
        List<DadosLivro> listaLivros = respostaBusca.resultado();
        if (listaLivros.isEmpty()) {
            throw new RuntimeException("Nenhum livro encontrado para o termo: " + termoDeBusca);
        }
        var primeiroResultado = listaLivros.getFirst();
        return primeiroResultado;
    }
//
//    @Override
//    public DadosLivro buscar(String termoDeBusca) {
//        String url = BASE_URL + "?search=" + termoDeBusca.replace(" ", "+");
//
//        var json = HttpClientHelper.get(url);
//        DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);
//        return dadosLivro;
//    }
}
