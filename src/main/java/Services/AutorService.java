
package Services;

import java.util.ArrayList;
import java.util.List;
import model.Autor;


public class AutorService {
    private List<Autor> autores;
    
    public AutorService(){
        this.autores = new ArrayList<>();
    }
    
    public void cadastrarAutor(Autor autor){
        for(Autor autorAtual : autores){
         if(autorAtual.getNome().equalsIgnoreCase(autor.getNome())){
             
            System.out.println("Autor já cadastrado.");
            return;
            }   
        }
        autores.add(autor);

        System.out.println("Autor cadastrado com sucesso.");
    }
    public void listarAutores(){

        if(autores.isEmpty()){

            System.out.println("Nenhum autor cadastrado.");
            return;
        }
        for(Autor autor : autores){
             System.out.println(autor);
        }
    }
    public Autor buscarAutor(String nome){

        for(Autor autor : autores){

            if(autor.getNome().equalsIgnoreCase(nome)){
                return autor;
            }   
        }
        return null;
    }
    
    public Autor buscarAutorPorNome(String nome){

        for(Autor autor : autores){

            if(
                autor.getNome().equalsIgnoreCase(nome)){
                return autor;
            }
        }

        return null;
    }
    
    public void atualizarAutor(String nomeAtual,String novoNome,String novaNacionalidade,String novoGenero){

        Autor autor =buscarAutorPorNome(nomeAtual);

        if(autor == null){
            System.out.println("Autor não encontrado.");
            return;
        }

        autor.setNome(novoNome);
        autor.setNacionalidade(novaNacionalidade);
        autor.setCategoriaPrincipal(novoGenero);

        System.out.println("Autor atualizado com sucesso." );
    }
    
    public void removerAutor(String nome){

        Autor autor = buscarAutor(nome);

        if(autor == null){

            System.out.println("Autor não encontrado.");

            return;
        }

        autores.remove(autor);

        System.out.println("Autor removido com sucesso.");
    }
    
}
