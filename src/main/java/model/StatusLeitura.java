
package model;

// Classe que define constantes de status de leitura
public enum StatusLeitura {
    NAO_LIDO("Não Lido"),
    LENDO("Lendo"),
    LIDO("Lido");
    
    private String descricao;
    
    StatusLeitura(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
