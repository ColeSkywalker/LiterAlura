package br.com.alura.literalura.search;

import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class ConsultaAutor {
    private AutorRepository autorRepository;

    public ConsultaAutor(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public String listarAutores() {
        return autorRepository.findAll()
                .stream()
                .map(Autor::toString)
                .collect(Collectors.joining("\n"));
    }

    public String listarAutoresVivosDeterminadoAno(){
        System.out.println("Digite um ano: ");
        Scanner leitura = new Scanner(System.in);
        int ano = leitura.nextInt();

        List<Autor> autoresVivos = autorRepository
                .findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThan(ano, ano);

        if (autoresVivos.isEmpty()) {
            return "Nenhum autor estava vivo nesse ano.";
        }

        return autoresVivos.stream()
                .map(Autor::toString)
                .collect(Collectors.joining("\n"));
    }

}
