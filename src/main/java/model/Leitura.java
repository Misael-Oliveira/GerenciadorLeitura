/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Livro;
import model.Usuario;

/**
 *
 * @author Usuário
 */
public class Leitura {
    private Livro livro;
    private Usuario usuario;
    private String status;
    private int paginaAtual;
    private int avaliacao;
    
    public Leitura(Livro  livro, Usuario usuario){
        this.setLivro(livro);
        this.setUsuario(usuario);
        
    }
    
    public void marcarLido(){
        setStatus("Lido");
    }
    
    public void marcarLendo(){
        setStatus("Lendo");
    }
    
    public void avaliacaoLeitura(int avaliacao){
        this.setAvaliacao(avaliacao);
    }
    public void paginasLidas(int paginas){
        setPaginaAtual(getPaginaAtual()+ paginas);
    }

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the paginaAtual
     */
    public int getPaginaAtual() {
        return paginaAtual;
    }

    /**
     * @param paginaAtual the paginaAtual to set
     */
    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    /**
     * @return the avaliacao
     */
    public int getAvaliacao() {
        return avaliacao;
    }

    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}

