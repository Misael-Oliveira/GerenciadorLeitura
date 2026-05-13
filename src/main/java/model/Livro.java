
package model;


public class Livro {
    private Autor autor;
    private String titulo;
    private int numeroPaginas;
    private int anoPublicacao;
    private String editora;
    
    public Livro(String titulo, Autor autor, int numeroPaginas, int anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
         
        if(numeroPaginas > 0){
            this.numeroPaginas = numeroPaginas;
        }
        this.anoPublicacao = anoPublicacao;
    }

   
    @Override
    public String toString(){
        return "Nome :" +getTitulo()+
            " | Autor: " +getAutor().getNome()+
            " | Ano de Publicacao: "+ getAnoPublicacao();
    }
    
    public Autor getAutor() {
        return autor;
    }

    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

   
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        
        if(numeroPaginas > 0){
            this.numeroPaginas = numeroPaginas;
        }
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    
    public String getEditora() {
        return editora;
    }

    
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
}
