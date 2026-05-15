
package Services;

import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Usuario;

public class UsuarioService {
    private List<Usuario> usuarios;
    
    public UsuarioService(){
        this.usuarios = new ArrayList <>();
    }
    
    public void cadastrarUsuario(Usuario usuario){
        for(Usuario usuarioAtual : usuarios){
         if(usuarioAtual.getNome().equalsIgnoreCase(usuario.getNome())){
             
            System.out.println("Usuario já cadastrado.");
            return;
            }   
        }
        usuarios.add(usuario);

        System.out.println("Usuario cadastrado com sucesso.");
    }
    public void listarUsuarios(){

        if(usuarios.isEmpty()){

            System.out.println("Nenhum usuario cadastrado.");
            return;
        }
        for(Usuario usuario : usuarios){
             System.out.println(usuario);
        }
    }
    public Usuario buscarUsuario(String nome){

        for(Usuario usuario : usuarios){

            if(usuario.getNome().equalsIgnoreCase(nome)){
                return usuario;
            }   
        }
        return null;
    }
    
    public void removerUsuario(String nome){

        Usuario usuario = buscarUsuario(nome);

        if(usuario == null){

            System.out.println("Usaurio não encontrado.");

            return;
        }

        usuarios.remove(usuario);

        System.out.println("Usuario removido com sucesso.");
    }
    
}
