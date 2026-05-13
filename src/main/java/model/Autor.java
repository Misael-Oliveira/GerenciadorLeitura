
package model;


public class Autor {
    private String nome;
    private String nacionalidade;
    private String generoPrincipal;
    
    public Autor (String nome, String nacionalidade, String generoPrincipal){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.generoPrincipal = generoPrincipal;
    }

    @Override
    public String toString(){
        return "Nome :" +getNome()+
            " | nacionalidade: " +getNacionalidade()+
            " | Genero Principal: "+ getGeneroPrincipal();
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
    public String getGeneroPrincipal() {
        return generoPrincipal;
    }

    /**
     * @param generoLiterario the generoLiterario to set
     */
    public void setGeneroLiterario(String generoPrincipal) {
        this.generoPrincipal = generoPrincipal;
    }
}
