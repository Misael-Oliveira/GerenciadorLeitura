
package Services;

import java.util.ArrayList;
import java.util.List;
import model.Leitura;
import model.Livro;
import model.StatusLeitura;
import model.Usuario;

/**
 *
 * @author Usuário
 */
public class LeituraService {
    

    private List<Leitura>leituras;
    
    public LeituraService(){
        this.leituras = new ArrayList<>();
    }
    
    public Leitura cadastrarLeitura(Usuario usuario, Livro livro){
        for(Leitura leitura : leituras){

            if(leitura.getUsuario().getNome().equals(usuario.getNome()) && leitura.getLivro().getTitulo().equals(livro.getTitulo()) ) {
                System.out.println("Leitura já cadastrada.");

            return null;
        }
    }

        
        Leitura leitura = new Leitura(usuario, livro);
        leituras.add(leitura);
        return leitura;
    }
    
    public void listarLeitura(){
        for(int i=0; i <leituras.size(); i++){
            System.out.println(leituras.get(i));
        }
    }
    
    public void iniciarLeitura(Leitura leitura){
        leitura.marcarLendo();
    }
    public void adicionarPaginasLidas(Leitura leitura,int paginas){
        if (leitura.getStatus() == StatusLeitura.LIDO){
            System.out.println("Leitura já finalizada.");
            return;
        }
        leitura.adicionarPaginasLidas(paginas);
    }
    
    public void finalizarLeitura(Leitura leitura){
        int restante =leitura.getLivro().getNumeroPaginas()- leitura.getPaginaAtual();
        leitura.adicionarPaginasLidas(restante);;
    }
    
    public void avaliarLivro(Leitura leitura, int nota){
        if (leitura.getStatus() != StatusLeitura.LIDO){
            System.out.println("Finalize a leitura antes de avaliar.");
            return;
        }
        
        leitura.avaliacaoLeitura(nota);
        
    }
    
    public void gerarRelatorio(){
        
    }
    
    public void recomendarLivro(){
        
    }
}
