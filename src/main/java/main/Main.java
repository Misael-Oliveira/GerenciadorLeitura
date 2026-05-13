
package main;

import Services.LeituraService;

import model.Autor;
import model.Leitura;
import model.Livro;
import model.Usuario;

public class Main {
    public static void main(String[] args){
        Usuario usuario = new Usuario("Misael", "misael@gmail.com");

        Autor autor = new Autor("Machado de Assis", "brasileiro", "romance");

        Livro livro = new Livro("Dom Casmurro", autor, 250, 1850);

        LeituraService service = new LeituraService();

        Leitura leitura =  service.cadastrarLeitura(usuario, livro);
        
       // service.iniciarLeitura(leitura);
        
        //service.paginasLidas(leitura, 6);
        
        //service.avaliarLivro(leitura, 4);
        //service.avaliarLivro(leitura, 8);
       // service.finalizarLeitura(leitura);

        //service.listarLeitura();
        
        Usuario usuario1 = new Usuario("Misael", "misael@gmail.com");

        Autor autor1 = new Autor("Machao de Assis", "brasileiro", "romance");

        Livro livro1 = new Livro("Dom Casmurro", autor1, 250, 185);

        //LeituraService service1 = new LeituraService();

       service.listarLeitura();
       //service.cadastrarLeitura(usuario, livro1);
       //service.listarLeitura();
        
        //service.adicionarPaginasLidas(leitura1, 6);
        
        
        service.finalizarLeitura(leitura);
        
        service.listarLeitura();
    }
            
            
}
