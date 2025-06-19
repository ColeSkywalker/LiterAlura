package br.com.alura.literalura.search;
import br.com.alura.literalura.http.HttpClientHelper;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.DadosAutor;
import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConverteDados;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


@Service
public class ConsultaLivros {
    private static final String BASE_URL = "https://gutendex.com/books";
    ConverteDados conversor = new ConverteDados();
    private LivroRepository repositorioLivro;
    private AutorRepository autorRepository;

    public ConsultaLivros(LivroRepository repositorioLivro, AutorRepository autorRepository) {
        this.repositorioLivro = repositorioLivro;
        this.autorRepository = autorRepository;
    }

    public Livro buscar(String termoDeBusca) { // Busca livro na API
        String url = BASE_URL + "?search=" + termoDeBusca.replace(" ", "+");

        var json = HttpClientHelper.get(url);
        RespostaBusca respostaBusca = conversor.obterDados(json, RespostaBusca.class); // Converte todos os resultados da pesquisa em JSON
        List<DadosLivro> listaLivros = respostaBusca.resultado();
        if (listaLivros.isEmpty()) {
            throw new RuntimeException("Nenhum livro encontrado para o termo: " + termoDeBusca);
        }
        Livro livro = new Livro(listaLivros.getFirst());  // Passa os dados de DadosLivros para Livro
        DadosAutor dadosAutor = listaLivros.getFirst().autor().getFirst(); // Pega o primeiro autor do primeiro livro encontrado na busca
        Autor autor = autorRepository.findByNome(dadosAutor.nomeAutor())
                .orElseGet(() -> {
                    Autor novoAutor = new Autor(dadosAutor);
                    return autorRepository.save(novoAutor);
                });

        livro.setAutor(autor);       // associa ao livro

        if (autor.getLivrosEscritos() == null) {
            autor.setLivrosEscritos(new ArrayList<>());
        }
        autor.getLivrosEscritos().add(livro);


        autorRepository.save(autor);

        return livro;
    }

    public void listarLivrosRegistrados() {
        var livro = repositorioLivro.findAll();
        livro.stream().forEach(System.out::println);
    }

    public String livrosPorIdioma() {
        String idiomaSelecionado = "";
        int escolha = 0;

        System.out.println("Selecione um idioma: ");
        System.out.println("Inglês - 1 | Portugues - 2 | Espanhol - 3");
        Scanner leitura = new Scanner(System.in);


        try {
            escolha = leitura.nextInt();
        } catch (Exception e) {
            System.out.println("Caractere digitado inválido, utilize apenas os números inteiros 1|2|3");
            leitura.nextLine();
        }

        if (escolha == 1) {
            idiomaSelecionado = "en";
        } else if (escolha == 2) {
            idiomaSelecionado = "pt";
        } else if (escolha == 3) {
            idiomaSelecionado = "es";
        } else {
            return "O caractere digitado não é válido";
        }

        List<Livro> livro = repositorioLivro.findByIdiomaOriginalContainingIgnoreCase(idiomaSelecionado);
        if (livro.isEmpty()) {
            return "Não encontramos livros registrados com o idioma selecionado.";
        } else {
            return livro.stream()
                    .map(Livro::toString)
                    .collect(Collectors.joining("\n"));
        }
    }
}
