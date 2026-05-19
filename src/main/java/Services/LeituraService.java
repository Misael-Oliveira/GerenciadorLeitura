
package Services;

import java.util.ArrayList;
import java.util.List;
import model.Leitura;
import model.Livro;
import model.StatusLeitura;
import model.Usuario;


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

        //Não permite avaliações antes da finalização da leitura
        if (leitura.getStatus() != StatusLeitura.LIDO){
            System.out.println("Finalize a leitura antes de avaliar.");
            return;
        }
        
        leitura.avaliacaoLeitura(nota);
        
    }
    
    public Leitura buscarLeitura(Usuario usuario,Livro livro){

        for(Leitura leitura : leituras){

            if(leitura.getUsuario().equals(usuario)&& leitura.getLivro().equals(livro)){
                return leitura;
            }
        }

        return null;
    }
    
    public void removerLeitura(Leitura leitura){

        if(leitura == null){

            System.out.println("Leitura não encontrada.");

            return;
        }

        leituras.remove(leitura);

        System.out.println("Leitura removida com sucesso.");
    }
    
    
    
    public int totalLeiturasUsuario(Usuario usuario){
        int total = 0;

        for(Leitura leitura : leituras){
            if(leitura.getUsuario().equals(usuario)){
                total++;
            }
        }

        return total;
    }

    public int livrosFinalizadosUsuario(Usuario usuario){
        int total = 0;

        for(Leitura leitura : leituras){

            if(leitura.getUsuario().equals(usuario)&&leitura.getStatus()== StatusLeitura.LIDO){
                total++;
            }
        }

        return total;
    }

    public int livrosEmAndamentoUsuario(Usuario usuario){
        int total = 0;

        for(Leitura leitura : leituras){
            if(leitura.getUsuario().equals(usuario)&&leitura.getStatus()== StatusLeitura.LENDO){
                total++;
            }
        }
        return total;
    }

    public int totalPaginasLidasUsuario(Usuario usuario){
        int total = 0;

        for(Leitura leitura : leituras){
            if(leitura.getUsuario().equals(usuario)){
                total += leitura.getPaginaAtual();
            }
        }
        return total;
    }
}
