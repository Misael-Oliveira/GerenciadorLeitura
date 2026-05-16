
package Controllers;

import Services.AutorService;
import Services.LeituraService;
import Services.LivroService;
import Services.UsuarioService;
import java.util.Scanner;
import model.Autor;
import model.Leitura;

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
    
    public void listarUsuarios(){
        usuarioService.listarUsuarios();
    }
    
    public void atualizarUsuario(){

        System.out.println("Nome atual:");

        String nomeAtual = scanner.nextLine();

        System.out.println("Novo nome:");

        String novoNome =scanner.nextLine();

        System.out.println("Novo email:");

        String novoEmail =scanner.nextLine();

        usuarioService.atualizarUsuario(nomeAtual,novoNome,novoEmail);
}
    
    public void removerUsuario(){
        System.out.println("Nome do usuário:");
        String nome =scanner.nextLine();

        usuarioService.removerUsuario(nome);
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
   
    public void listarAutores(){
        if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }
        autorService.listarAutores();
    }
    
    public void atualizarAutor(){
        System.out.println("Nome atual:");
        String nomeAtual = scanner.nextLine();

        System.out.println("Novo nome:");
        String novoNome =scanner.nextLine();

        System.out.println("Nova nacionalidade:");

        String nacionalidade =scanner.nextLine();

        System.out.println("Novo gênero:");

        String genero =scanner.nextLine();

        autorService.atualizarAutor(nomeAtual,novoNome, nacionalidade, genero);
    }
    
    public void removerAutor(){
        System.out.println("Nome do autor:");
        String nome = scanner.nextLine();

        autorService.removerAutor(nome);
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
    
    
    public void listarLivros(){
        if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }
        livroService.listarLivros();
    }
    
    public void atualizarLivro(){

    System.out.println("Título atual:");

    String tituloAtual =scanner.nextLine();

    System.out.println("Novo título:");

    String novoTitulo =scanner.nextLine();

    System.out.println("Novo número de páginas:");

    int paginas =scanner.nextInt();
    scanner.nextLine();

    System.out.println("Novo ano:");

    int ano =scanner.nextInt();
    scanner.nextLine();

    livroService.atualizarLivro(tituloAtual,novoTitulo,paginas,ano);
}
    
    public void removerLivro(){
        System.out.println("Título do livro:");

        String titulo = scanner.nextLine();

        livroService.removerLivro(titulo);
    }
    

    public void cadastrarLeitura(){
       
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

        leituraService.cadastrarLeitura(usuarioLogado, livro);

        System.out.println("Leitura cadastrada com sucesso.");
    }
    
    public void iniciarLeitura(){
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
        Leitura leitura =leituraService.buscarLeitura(usuarioLogado,livro);

        if(leitura == null){

            System.out.println("Leitura não encontrada.");
            return;
        }

        leituraService.iniciarLeitura(leitura);

        System.out.println("Leitura iniciada com sucesso.");
    }
        
        
    
    
    public void listarLeituras(){
        if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }
        leituraService.listarLeitura();
    }
    
    public void adicionarPaginasLidas(){

        if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }

        System.out.println("Título do livro:");
        String titulo = scanner.nextLine();

        Livro livro = livroService.buscarLivroPorTitulo(titulo);

        if(livro == null){

            System.out.println("Livro não encontrado.");
            return;
        }

        Leitura leitura =leituraService.buscarLeitura(usuarioLogado,livro);

        if(leitura == null){

            System.out.println("Leitura não encontrada.");
            return;
        }

        System.out.println("Quantidade de páginas:");
        int paginas = scanner.nextInt();
        scanner.nextLine();

        leituraService.adicionarPaginasLidas(leitura,paginas);
    }
    
    public void finalizarLeitura(){

        if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }

        System.out.println("Título do livro:");
        String titulo = scanner.nextLine();

        Livro livro = livroService.buscarLivroPorTitulo(titulo);

        if(livro == null){
            System.out.println("Livro não encontrado.");
            return;
        }

        Leitura leitura =leituraService.buscarLeitura(usuarioLogado,livro);

        if(leitura == null){
            System.out.println("Leitura não encontrada.");
            return;
        }

        leituraService.finalizarLeitura(leitura);

        System.out.println("Leitura finalizada.");
    }
    
    public void removerLeitura(){

        if(usuarioLogado == null){

            System.out.println("Faça login primeiro.");

            return;
        }

        System.out.println("Título do livro:");

        String titulo =scanner.nextLine();

        Livro livro =livroService.buscarLivroPorTitulo(titulo);

        if(livro == null){

            System.out.println("Livro não encontrado.");

            return;
        }

        Leitura leitura =leituraService.buscarLeitura(usuarioLogado,livro);

        leituraService.removerLeitura(leitura);
    }
    
    public void avaliarLivro(){

        if(usuarioLogado == null){
            System.out.println("Faça login primeiro.");
            return;
        }

        System.out.println("Título do livro:");
        String titulo = scanner.nextLine();

        Livro livro = livroService.buscarLivroPorTitulo(titulo);

        if(livro == null){
            System.out.println("Livro não encontrado.");
            return;
        }

        Leitura leitura =leituraService.buscarLeitura(usuarioLogado,livro);

        if(leitura == null){
            System.out.println("Leitura não encontrada.");
            return;
        }

        System.out.println("Nota:");
        int nota = scanner.nextInt();

        leituraService.avaliarLivro(leitura,nota);
    }
    
    public void gerarRelatorio(){

    if(usuarioLogado == null){
        System.out.println( "Faça login primeiro.");
        return;
    }

    System.out.println("\n===== RELATÓRIO =====");

    System.out.println("Usuário: "+ usuarioLogado.getNome());

    System.out.println("Total de leituras: "+ leituraService.totalLeiturasUsuario(usuarioLogado));

    System.out.println("Livros finalizados: "+ leituraService.livrosFinalizadosUsuario(usuarioLogado));

    System.out.println("Livros em andamento: "+ leituraService.livrosEmAndamentoUsuario(usuarioLogado));

    System.out.println("Total de páginas lidas: "+ leituraService.totalPaginasLidasUsuario(usuarioLogado));
}
    
    
    public void menuUsuarios(){

        int opcao;

        do{

            System.out.println(
                "\n===== USUÁRIOS ====="
            );

            System.out.println(
                "[1] Cadastrar"
            );

            System.out.println(
                "[2] Listar"
            );

            System.out.println(
                "[3] Atualizar"
            );

            System.out.println(
                "[4] Remover"
            );

            System.out.println(
                "[0] Voltar"
            );

            System.out.print("\nEscolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:

                    cadastrarUsuario();

                    break;

                case 2:

                    listarUsuarios();

                    break;

                case 3:

                    atualizarUsuario();

                    break;

                case 4:

                    removerUsuario();

                    break;

                case 0:

                    break;

                default:

                    System.out.println(
                        "Opção inválida."
                    );
            }

        }while(opcao != 0);
    }
    
    public void menuLivros(){

        int opcao;

        do{

            System.out.println(
                "\n===== LIVROS ====="
            );

            System.out.println(
                "[1] Cadastrar"
            );

            System.out.println(
                "[2] Listar"
            );

            System.out.println(
                "[3] Atualizar"
            );

            System.out.println(
                "[4] Remover"
            );

            System.out.println(
                "[0] Voltar"
            );

            System.out.print("\nEscolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:

                    cadastrarLivro();

                    break;

                case 2:

                    listarLivros();

                    break;

                case 3:

                    atualizarLivro();

                    break;

                case 4:

                    removerLivro();

                    break;

                case 0:

                    break;

                default:

                    System.out.println(
                        "Opção inválida."
                    );
            }

        }while(opcao != 0);
    }
    
    public void menuLeituras(){

        int opcao;

        do{

            System.out.println(
                "\n===== LEITURAS ====="
            );

            System.out.println(
                "[1] Cadastrar leitura"
            );
            
            System.out.println(
                "[2] Iniciar leituras"
            );

            System.out.println(
                "[3] Listar leituras"
            );

            System.out.println(
                "[4] Adicionar páginas"
            );

            System.out.println(
                "[5] Finalizar leitura"
            );

            System.out.println(
                "[6] Avaliar livro"
            );

            System.out.println(
                "[7] Remover leitura"
            );

            System.out.println(
                "[0] Voltar"
            );

            System.out.print("\nEscolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:

                    cadastrarLeitura();

                    break;
                    
                case 2:

                    iniciarLeitura();

                    break;    

                case 3:

                    listarLeituras();

                    break;

                case 4:

                    adicionarPaginasLidas();

                    break;

                case 5:

                    finalizarLeitura();

                    break;

                case 6:

                    avaliarLivro();

                    break;

                case 7:

                    removerLeitura();

                    break;

                case 0:

                    break;

                default:

                    System.out.println(
                        "Opção inválida."
                    );
            }

        }while(opcao != 0);
    }
    
    
    public void menuAutores(){

        int opcao;

        do{

            System.out.println(
                "\n===== AUTORES ====="
            );

            System.out.println(
                "[1] Cadastrar Autor"
            );

            System.out.println(
                "[2] Listar Autores"
            );

            System.out.println(
                "[3] Atualizar Autor"
            );

            System.out.println(
                "[4] Remover Autor"
            );

            System.out.println(
                "[0] Voltar"
            );

            System.out.print("\nEscolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:

                    cadastrarAutor();

                    break;

                case 2:

                    listarAutores();

                    break;

                case 3:

                    atualizarAutor();

                    break;

                case 4:

                    removerAutor();

                    break;

                case 0:

                    break;

                default:

                    System.out.println(
                        "Opção inválida."
                    );
            }

        }while(opcao != 0);
    }
    
public void exibirMenu(){

    int opcao;

    do{

        System.out.println(
            "\n===== MENU PRINCIPAL ====="
        );

        System.out.println(
            "[1] Login"
        );

        System.out.println(
            "[2] Logout"
        );

        System.out.println(
            "[3] Usuários"
        );

        System.out.println(
            "[4] Autores"
        );

        System.out.println(
            "[5] Livros"
        );

        System.out.println(
            "[6] Leituras"
        );

        System.out.println(
            "[7] Relatórios"
        );

        System.out.println(
            "[0] Sair"
        );

        System.out.print("\nEscolha: ");

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

                menuUsuarios();

                break;

            case 4:

                menuAutores();

                break;

            case 5:

                menuLivros();

                break;

            case 6:

                menuLeituras();

                break;

            case 7:

                gerarRelatorio();

                break;

            case 0:

                System.out.println(
                    "Sistema encerrado."
                );

                break;

            default:

                System.out.println(
                    "Opção inválida."
                );
        }

    }while(opcao != 0);
}
   
   
}
