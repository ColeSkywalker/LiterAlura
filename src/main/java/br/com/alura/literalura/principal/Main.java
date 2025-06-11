package br.com.alura.literalura.principal;

import br.com.alura.literalura.service.GutendexService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menuInicial = """
                Escolha uma das opções abaixo:
                1 - buscar livro pelo título
                2 - listar livros registrados
                3 - listar autores registrados
                4 - listar autores vivos em um determinado ano
                5 - listar livros em um determinado idioma
                0 - sair
                
                """;
        Scanner leitura = new Scanner(System.in);
        var opcao = -1;
        GutendexService g = new GutendexService();
        System.out.println(menuInicial);
        opcao = leitura.nextInt();
        leitura.nextLine();
        String busca;

            switch (opcao){
                case 1:
                    System.out.print("Digite o título do livro para buscar: ");
                    busca = leitura.nextLine();
                    String resultado = g.buscarLivros(busca);
                    System.out.println(resultado);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor inválido");
                    break;

        }

    }
}