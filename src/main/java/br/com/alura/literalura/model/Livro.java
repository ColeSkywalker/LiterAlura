package br.com.alura.literalura.model;

public class Livro {
    private String titulo;
    private String autor;
    private String sinopse;
    private String genero;
    private String idiomaOriginal;
    private String numeroDownloads;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(String numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }


}
