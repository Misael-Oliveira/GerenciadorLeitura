/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import model.Livro;
import model.Usuario;

/**
 *
 * @author Usuário
 */
public class Leitura {
    private Livro livro;
    private Usuario usuario;
    private String status = "Não lido";
    private int avaliacao = 0;
    
    public void Leitura(Livro  livro, Usuario usuario){
        this.livro = livro;
        this.usuario = usuario;
    }
    
    public void marcarLido(){
        status = "Lido";
    }
    
    public void marcarLendo(){
        status = "Lendo";
    }
    
    public void avaliacaoLeitura(int avaliacao){
        this.avaliacao = avaliacao;
    }
}
