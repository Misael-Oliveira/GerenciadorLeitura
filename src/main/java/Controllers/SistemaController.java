
package Controllers;

import Services.AutorService;
import Services.LeituraService;
import Services.LivroService;
import Services.UsuarioService;
import java.util.Scanner;
import model.Autor;

import model.Livro;
import model.Usuario;

public class SistemaController {
    
   private LivroService livroService;
   private UsuarioService usuarioService;
   private AutorService autorService;
   private LeituraService leituraService;
   private Usuario usuarioLogado;
   private Scanner scanner;
   
   public SistemaController(){
       livroService = new LivroService();
       usuarioService = new UsuarioService();
       autorService = new AutorService();
       leituraService = new LeituraService();
       scanner = new Scanner(System.in);
   }
   
    public void cadastrarUsuario(){
       System.out.println("Digite o nome do usuario: ");
       String nome = scanner.nextLine();
       
       System.out.println("Digite o email:");
       String email = scanner.nextLine();
       scanner.nextLine();
       
       Usuario usuario = new Usuario(nome, email);
       usuarioService.cadastrarUsuario(usuario);       
   } 
   
   public void login(){
       System.out.println("Nome do usuário:");
       String nome = scanner.nextLine();

        Usuario usuario = usuarioService.buscarUsuario(nome);

        if(usuario == null){
             System.out.println("Usuário não encontrado.");
             return;
        }

        usuarioLogado = usuario;
        System.out.println("Login realizado com sucesso.");
    }
   
   public void logout(){
        usuarioLogado = null;
        System.out.println("Logout realizado.");
    }
   
   public void cadastrarLivro(){
       if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }
       
       System.out.println("Digite o Titulo do livro: ");
       String titulo = scanner.nextLine();
       
       System.out.println("Número de páginas:");
       int paginas = scanner.nextInt();
       scanner.nextLine();
       
       System.out.println("Ano de publicação:");
       int ano = scanner.nextInt();
       scanner.nextLine();
        
       System.out.println("Nome do autor:");
       String nomeAutor = scanner.nextLine();
       
       Autor autor = autorService.buscarAutor(nomeAutor);
       
       if(autor == null){
           System.out.println("Autor não encontrado.");
           return;
       }
       
       Livro livro = new Livro(titulo, autor, paginas, ano);
       livroService.cadastrarLivro(livro);
   }

   public void cadastrarAutor(){
       if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }
       
       System.out.println("Digite o nome do autor: ");
       String nome = scanner.nextLine();
       
       System.out.println("Digite a nacionalidade:");
       String nacionalidade = scanner.nextLine();
       scanner.nextLine();
       
       System.out.println("Digite a categoria princial do autor:");
       String categoria = scanner.nextLine();
       scanner.nextLine();
       
       Autor autor = new Autor(nome, nacionalidade, categoria);
       autorService.cadastrarAutor(autor);  
   }
   
    public void iniciarLeitura(){
        System.out.println("Nome do usuário:");
        String nomeUsuario = scanner.nextLine();

        Usuario usuario =usuarioService.buscarUsuario(nomeUsuario);

        if(usuario == null){
            System.out.println("Usuário não encontrado.");
            return;
        }
        if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }

        System.out.println("Título do livro:");
        String tituloLivro = scanner.nextLine();

        Livro livro = livroService.buscarLivroPorTitulo(tituloLivro);

        if(livro == null){
            System.out.println("Livro não encontrado.");
            return;
        }

        leituraService.cadastrarLeitura(usuario, livro);

        System.out.println("Leitura iniciada com sucesso.");
    }
    
    public void listarLivros(){
        livroService.listarLivros();
    }
    
    public void listarAutores(){
        autorService.listarAutores();
    }
    
    public void listarUsuarios(){
        usuarioService.listarUsuarios();
    }
    
    public void listarLeituras(){

        leituraService.listarLeitura();
    }
    
    public void exibirMenu(){
        int opcao = -1;
        
        while(opcao !=0) {
            System.out.println("\n=== SISTEMA DE LEITURA ===");
            
            System.out.println("1 - Login");
            System.out.println("2 - Logout");
            System.out.println("1 - Cadastrar Autor");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Iniciar Leitura");

            System.out.println("5 - Listar Livros");
            System.out.println("6 - Listar Autores");
            System.out.println("7 - Listar Usuários");

            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao){
                case 1:
                    login();
                    break;

                case 2:
                    logout();
                    break;
                case 3:
                    cadastrarAutor();
                    break;

                case 4:
                    cadastrarLivro();
                    break;

                case 3:
                    cadastrarUsuario();
                    break;

                case 4:
                    iniciarLeitura();
                    break;
                    
                case 5:
                    listarLivros();
                    break;

                case 6:
                    listarAutores();
                    break;

                case 7:
                    listarUsuarios();
                    break; 
                    
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    
    public void avaliarLivro(){
       
    }
   
   
}
