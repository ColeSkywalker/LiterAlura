package br.com.alura.literalura.service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutendexService {
    private static final String BASE_URL = "https://gutendex.com/books";

    public String buscarLivros(String termoDeBusca) {
        String url = BASE_URL + "?search=" + termoDeBusca.replace(" ", "+");


        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        System.out.println("URL gerada: " + url);

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao buscar livros: " + e.getMessage(), e);
        }
    }


}
