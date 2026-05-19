
package model;


public class Autor {
    private String nome;
    private String nacionalidade;
    private String categoriaPrincipal;
    
    public Autor (String nome, String nacionalidade, String categoriaPrincipal){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Valor invalido de nome do autor.");
            return;
        }
        
        if(categoriaPrincipal == null || nome.trim().isEmpty()){
            System.out.println("Valor invalido de categoria principal.");
            return;
        }
        
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.categoriaPrincipal = categoriaPrincipal;
    }

    @Override
    public String toString(){
        return "Nome :" +getNome()+
            " | nacionalidade: " +getNacionalidade()+
            " | Genero Principal: "+ getCategoriaPrincipal();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    public void setCategoriaPrincipal(String categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }
}
