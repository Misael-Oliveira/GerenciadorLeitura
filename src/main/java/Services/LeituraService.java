
package Services;

import java.util.ArrayList;
import java.util.List;
import model.Leitura;
import model.Livro;
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
    
    public void cadastrarLeitura(Usuario usuario, Livro livro){
        Leitura leitura = new Leitura(usuario, livro);
        leituras.add(leitura);
    }
    
    public void listarLeitura(){
        for(int i=0; i <leituras.size(); i++){
            System.out.println(leituras.get(i));
        }
    }
    
    public void iniciarLeitura(Leitura leitura){
        leitura.marcarLendo();
    }
    public void paginasLidas(Leitura leitura,int paginas){
        leitura.paginasLidas(paginas);
    }
    
    public void finalizarLeitura(Leitura leitura){
        leitura.marcarLido();
    }
    
    public void avaliarLivro(Leitura leitura, int nota){
        leitura.avaliacaoLeitura(nota);
    }
    
    public void gerarRelatorio(){
        
    }
    
    public void recomendarLivro(){
        
    }
}
