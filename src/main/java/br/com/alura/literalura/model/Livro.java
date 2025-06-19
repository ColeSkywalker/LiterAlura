package br.com.alura.literalura.model;
import jakarta.persistence.*;


@Entity
@Table(name="livro")
public class Livro {
    @Column(unique = true)
    private String titulo;
    private    String idiomaOriginal;
    private int numeroDownloads;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Livro() {

    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }


    public int getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(int numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public Livro(DadosLivro dados) {
        this.titulo = dados.titulo();
        this.idiomaOriginal = dados.idiomaOriginal().getFirst();
        this.numeroDownloads = dados.numeroDownloads();
    }

    @Override
    public String toString() {
        return String.format("""
                --------------------------
                Livro: %s
                Autor: %s
                Idioma: %s
                Número de downloads: %s
                --------------------------
                """ , titulo,
                autor != null ? autor.getNome() : "Desconhecido",
                idiomaOriginal,
                numeroDownloads);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
