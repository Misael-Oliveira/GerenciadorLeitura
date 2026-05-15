
package Services;

import java.util.ArrayList;
import java.util.List;
import model.Livro;


public class LivroService {
    private List<Livro>livros;
    
    public LivroService(){
        this.livros = new ArrayList<>();
    }
    
    public void cadastrarLivro(Livro livro){
        for(Livro livroAtual : livros){
         if(livroAtual.getTitulo().equalsIgnoreCase(livro.getTitulo())){
             
            System.out.println("Livro já cadastrado.");
            return;
            }   
        }
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso.");
    }
    public void listarLivros(){

        if(livros.isEmpty()){

            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for(Livro livro : livros){
             System.out.println(livro);
        }
    }
    public Livro buscarLivroPorTitulo(String titulo){

        for(Livro livro : livros){

            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }   
        }
        return null;
    }
    
    public void removerLivro(String titulo){

        Livro livro = buscarLivroPorTitulo(titulo);

        if(livro == null){

            System.out.println("Livro não encontrado.");

            return;
        }

        livros.remove(livro);

        System.out.println("Livro removido com sucesso.");
    }
    
}
