package com.beyondthecode.view;//<<<<<<< Updated upstream
import com.beyondthecode.entity.Post;
import com.beyondthecode.entity.User;
import com.beyondthecode.entity.interfaces.DeletePost;
import com.beyondthecode.entity.interfaces.EditPost;
import com.beyondthecode.service.PostService;
import com.beyondthecode.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Main implements EditPost, DeletePost {
  public static int idLog;
//  public static int idPost;
  public static int idToEdit;
  private static final UserService userservice = new UserService();
  private static final PostService postService = new PostService();
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int menu;
    boolean validar = true;

    System.out.println("----------------------// Bem vindo ao BTC //----------------------");
    System.out.println("..............▮▮▮▮▮...▮▮▮▮▮▮▮..▮▮▮▮▮▮..............");
    System.out.println("..............▮      ▮......▮▮..... ▮          ..............");
    System.out.println("..............▮▮▮▮▮.......▮▮.....▮           ..............");
    System.out.println("..............▮      ▮......▮▮......▮          ..............");
    System.out.println("..............▮▮▮▮▮.......▮▮.......▮▮▮▮▮▮...............");
    System.out.println("-------------------------------------------------------------------");

    while (validar) {
      System.out.println("1 - Login");
      System.out.println("2 - Cadastro");
      System.out.println("3 - Finalizar");
      menu = sc.nextInt();

      switch (menu) {
        case 1 -> Login();
        case 2 -> createUser();
        default -> validar = false;
      }
    }
  }


  // --------------------------------------------------------------------------
  // ---------------------------- *  USER METODS * ----------------------------
  // --------------------------------------------------------------------------

  public static void createUser() throws Exception {
    Scanner sc = new Scanner(System.in);
    User user = new User();

    System.out.println("E-mail");
    user.setEmail(sc.nextLine());
    System.out.println("Password");
    user.setPassword(sc.nextLine());
    System.out.println("Nome Completo");
    user.setName(sc.nextLine());

    User usuarioSalvo = userservice.salvarUserDB(user);
  }

  public static void Login() throws Exception {
    Scanner sc = new Scanner(System.in);

    System.out.print("E-mail: ");
    String email = sc.nextLine();
    System.out.print("Senha: ");
    String senha = sc.nextLine();

    // Verificar a autenticação no banco de dados
    User user = UserService.autenticarUsuario(email, senha);
    if (user != null) {
      System.out.println("Login bem-sucedido! Bem-vindo, " + user.getName() + "!");
      idLog = user.getId();
      boolean validar = true;
      while(validar){
        System.out.println("---- MENU ----");
        System.out.println("1 - Posts");
        System.out.println("2 - Editar Conta");
        System.out.println("3 - Excluir Conta");
        System.out.println("4 - Amigos");
        System.out.println("9 - LOGOUT");

        int menu = sc.nextInt();
        switch (menu) {
          case 1 -> Post();
          case 2 -> EditUser();
          case 3 -> ExcluirUser();
          case 4 -> userservice.listar();
          case 9 -> validar = false;
        }
      }
    } else {
      System.out.println("E-mail ou senha inválidos. Tente novamente.");
    }
  }

  public static void EditUser() throws Exception {
    User user = new User();
    Scanner sc = new Scanner(System.in);
    System.out.println("Editar Usuário:");
    System.out.println("1 - Editar Nome");
    System.out.println("2 - Editar Senha");
    System.out.println("3 - Editar E-mail");
    System.out.println("9 - Voltar");
    int menu = sc.nextInt();

    switch (menu) {
      case 1:
        System.out.print("Novo nome: ");
        sc.nextLine();
        String newName = sc.nextLine();
        user.setName(newName);
        userservice.editar(user); // Atualiza o usuário no banco de dados
        System.out.println("Nome atualizado com sucesso!");
        break;

      case 2:
        System.out.print("Nova senha: ");
        sc.nextLine();
        String newPassword = sc.nextLine();
        user.setPassword(newPassword);
        userservice.editar(user); // Atualiza o usuário no banco de dados
        System.out.println("Senha atualizada com sucesso!");
        break;

      case 3:
        System.out.print("Novo e-mail: ");
        sc.nextLine();
        String newEmail = sc.nextLine();
        user.setEmail(newEmail);
        userservice.editar(user); // Atualiza o usuário no banco de dados
        System.out.println("E-mail atualizado com sucesso!");
        break;

      case 9:
        // Voltar
        break;

      default:
        System.out.println("Opção inválida!");
    }
  }
  public static void ExcluirUser() throws Exception {
    Scanner sc = new Scanner(System.in);
    boolean validar = true;
    while(validar){
      System.out.println("Para excluir seu usuario aperte 1, para Voltar aperte 2");
      System.out.println("1 - Excluir Conta");
      System.out.println("2 - Voltar");

      int menu = sc.nextInt();
      switch (menu) {
        case 1:
          System.out.println("Tem certeza que deseja excluir sua conta? - 1");
          System.out.println("Voltar - 2");
          int z = sc.nextInt();
          switch (z) {
            case 1 -> {
              List<Post> posts = postService.listar(); // Obter a lista de posts do usuário
              for (Post post : posts) {
                postService.excluir(post.getIdPost()); // Excluir cada post associado
              }
              System.out.println("Excluindo conta...");
              userservice.excluir(idLog); // Excluir o usuário
              System.out.println("Conta excluída com sucesso!");
              System.out.println("Encerrando sessão!");
              System.exit(0);
            }
            case 2 -> validar = false;
            default -> System.out.println("Opção inválida!");
          }
          break;
        case 2:
          validar = false;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  public static void Post() throws Exception {
    Scanner sc = new Scanner(System.in);
    boolean validar = true;
    while(validar){
      System.out.println("Menu - Post");
      System.out.println("1 - Adicionar Post");
      System.out.println("2 - Alterar Post");
      System.out.println("3 - Excluir Post");
      System.out.println("4 - Visualizar Post");
      System.out.println("9 - Voltar");

      int menu = sc.nextInt();
      switch (menu) {
        case 1 -> AddPost();
        case 2 -> {
          System.out.println("Digite o ID do post que deseja editar: ");
          idToEdit = sc.nextInt();
          editPost();
        }
        case 3 -> {
          System.out.println("Digite o ID do post que deseja deletar: ");
          idToEdit = sc.nextInt();
          deletePost();
        }
        case 4 -> printPost();
        default -> validar = false;
      }
    }
  }

  // -------------------------------------------------------------------------
  // ---------------------------- * POST METODS * ----------------------------
  // -------------------------------------------------------------------------

  public static void AddPost() throws Exception {
    Post post = new Post();
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o Titulo do Post");
    post.setTitle(sc.nextLine());
    System.out.println("Digite o conteúdo do Post");
    post.setContents(sc.nextLine());


    System.out.println(post.getTitle());
    System.out.println(post.getContents());
    Post postSalvo = postService.salvarPost(post);
  }

  public static void deletePost() throws Exception {
    int idL = PostService.autenticarPost();
    System.out.println("Deletar Post: "+idToEdit);
    if(idL == idLog){
      Post post = new Post();
      Scanner sc = new Scanner(System.in);
      System.out.println("Deletar Post:");
      System.out.println("1 - Deletar Post");
      System.out.println("2 - Voltar");
      int menu = sc.nextInt();

      switch (menu) {
        case 1:
          postService.excluir(idToEdit);
          System.out.println("Post Excluido com sucesso");
          break;
        case 2:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }else{
      System.out.println("Esse id não é de sua conta");
    }
  }

  public static void editPost() throws Exception {
    int idL = PostService.autenticarPost();
    System.out.println("Editar Post: "+idToEdit);
    if(idL == idLog){
      Post post = new Post();
      Scanner sc = new Scanner(System.in);
      System.out.println("Editar Post:");
      System.out.println("1 - Editar Titulo");
      System.out.println("2 - Editar Conteúdo");
      System.out.println("9 - Voltar");
      int menu = sc.nextInt();

      switch (menu) {
        case 1:
          System.out.print("Novo Titulo: ");
          sc.nextLine();
          String newTitle = sc.nextLine();
          post.setTitle(newTitle);
          postService.editar(post); // Atualiza o Titulo no banco de dados
          System.out.println("Titulo atualizado com sucesso!");
          break;

        case 2:
          System.out.print("Novo Conteúdo: ");
          sc.nextLine();
          String newPassword = sc.nextLine();
          post.setContents(newPassword);
          postService.editar(post); // Atualiza o Conteúdo no banco de dados
          System.out.println("Conteúdo atualizada com sucesso!");
          break;

        case 9:
          // Voltar
          break;

        default:
          System.out.println("Opção inválida!");
    }
    }else{
      System.out.println("Esse id não é de sua conta");
    }
  }

  public static void printPost(){
      postService.listar();
  }
}


