package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.search.ConsultaAutor;
import br.com.alura.literalura.search.ConsultaLivros;

import java.util.Scanner;

public class Principal {
    private AutorRepository autorRepository;
    private LivroRepository livroRepository;
    public Principal(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }


    public void menu(){
        ConsultaLivros consultaLivros = new ConsultaLivros(livroRepository, autorRepository);
        ConsultaAutor consultaAutor = new ConsultaAutor(autorRepository);
        String menuInicial = """
                Escolha uma das opções abaixo:
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em um determinado idioma
                
                0 - Sair
                
                """;
        Scanner leitura = new Scanner(System.in);
        var opcao = -1;
        while(opcao!= 0){
            System.out.println(menuInicial);
            try {
                opcao = leitura.nextInt();
                leitura.nextLine();
            } catch (Exception e) {
                System.out.println("Caractere não permitido. " + e.getMessage());
                leitura.nextLine();
                opcao = -1;
            }
            String busca;
            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro para buscar: ");
                    busca = leitura.nextLine();
                    System.out.println(consultaLivros.buscar(busca));
                    break;
                case 2:
                    consultaLivros.listarLivrosRegistrados();
                    break;
                case 3:
                    System.out.println(consultaAutor.listarAutores());
                    break;
                case 4:
                    System.out.println(consultaAutor.listarAutoresVivosDeterminadoAno());
                    break;
                case 5:
                    System.out.println(consultaLivros.livrosPorIdioma());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor inválido");
                    break;
            }
        }
    }
}
