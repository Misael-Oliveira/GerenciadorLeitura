
package model;

import model.Livro;
import model.Usuario;


public class Leitura {
    private Livro livro;
    private Usuario usuario;
    private StatusLeitura status;
    private int paginaAtual;
    private int avaliacao;
    
    public Leitura(Usuario usuario, Livro  livro){
        this.setLivro(livro);
        this.setUsuario(usuario);
        this.status = StatusLeitura.NAO_LIDO;
        
    }
    
    public void marcarLido(){
        status=StatusLeitura.LIDO;
    }
    
    public void marcarLendo(){
        status=StatusLeitura.LENDO;
    }
    
    public void avaliacaoLeitura(int avaliacao){
        if(avaliacao >=1 && avaliacao <=5){
            this.avaliacao = avaliacao;
        }else{
            System.out.println("Valor não aceito.");
        }
    }
    
    public void adicionarPaginasLidas(int paginas){
         if(paginas <= 0) {
           System.out.println("Valor inválido de paginas.");
           return;
        }
         
        int total =getPaginaAtual() + paginas;
        
        if(total<getLivro().getNumeroPaginas()) {
           paginaAtual =getPaginaAtual()+ paginas;
           return;
        }
           
        if(getPaginaAtual() ==livro.getNumeroPaginas()){
            marcarLido();
            return;    
            
        }else {
            System.out.println("O número é maior que paginas total do livro.");
        }
    }
    
    @Override
    public String toString(){
        return"Livro: "+livro.getTitulo()+
                " | Autor: "+ livro.getAutor().getNome() +
                "\n Status: "+ status.getDescricao()+
                "\n Pagina Atual: "+getPaginaAtual()+
                "\n Avalição: "+ getAvaliacao()+"\n";
                
        
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
    public StatusLeitura getStatus() {
        return status;
    }

   

    /**
     * @return the paginaAtual
     */
    public int getPaginaAtual() {
        return paginaAtual;
    }

    /**
     * @return the avaliacao
     */
    public int getAvaliacao() {
        return avaliacao;
    }

   
}

