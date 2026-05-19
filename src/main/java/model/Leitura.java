
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
           
        paginaAtual = total;

        //Finaliza automaticamente a leitura quando todos as páginas forem lidas
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

    public Livro getLivro() {
        return livro;
    }
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public StatusLeitura getStatus() {
        return status;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

   
}

