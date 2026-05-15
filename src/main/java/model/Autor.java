
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

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the generoLiterario
     */
    public String getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    /**
     * @param generoLiterario the generoLiterario to set
     */
    public void setCategoriaPrincipal(String categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }
}
