/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuário
 */
public class Livro {
    private Autor autor;
    private String titulo;
    private int numeroPagin;
    private int anoPublicacao;
    private String editora;
    
    public Livro(String titulo, Autor autor, int numeroPaginas, int anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPagin = numeroPagin;
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the numeroPagin
     */
    public int getNumeroPaginas() {
        return numeroPagin;
    }

    /**
     * @param numeroPaginas the numeroPagin to set
     */
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPagin = numeroPaginas;
    }

    /**
     * @return the anoPublicacao
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * @param anoPublicacao the anoPublicacao to set
     */
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
}
