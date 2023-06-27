package com.beyondthecode.view;//<<<<<<< Updated upstream
import com.beyondthecode.database.DatabaseMemo;
import com.beyondthecode.entity.Post;
import com.beyondthecode.entity.User;
import com.beyondthecode.entity.enums.Message;
import com.beyondthecode.entity.interfaces.DeletePost;
import com.beyondthecode.entity.interfaces.EditPost;
import com.beyondthecode.entity.state.GeneralState;
import com.beyondthecode.service.UsuarioService;

import java.util.Optional;
import java.util.Scanner;

public class Main implements EditPost, DeletePost {
  private static UsuarioService usuarioservice = new UsuarioService();
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

    while (validar == true) {
      System.out.println("1 - Login");
      System.out.println("2 - Cadastro");
      System.out.println("3 - Finalizar");
      menu = sc.nextInt();

      switch (menu) {
        case 1:
          Login();
          break;

        case 2:
          createUser();
          break;
        default:
          validar = false;
      }
    }
  }


  public static void Post() {
    Scanner sc = new Scanner(System.in);
    boolean validar = true;
    while(validar == true){
      System.out.println("Logado com: " + GeneralState.loggedUser.getName());
      System.out.println("Menu - Post");
      System.out.println("1 - Adicionar Post");
      System.out.println("2 - Alterar Post");
      System.out.println("3 - Excluir Post");
      System.out.println("4 - Visualizar Post");
      System.out.println("9 - Voltar");

      int menu = sc.nextInt();
      switch (menu) {
        case 1:
          AddPost();
          break;
        case 2:
          System.out.println("Digite o ID do post que deseja editar: ");
          int idToEdit = sc.nextInt();
          editPost(idToEdit);
          break;
        case 3:
          System.out.println("Digite o ID do post que deseja deletar: ");
          int idToDelete = sc.nextInt();
          deletePost(idToDelete);
          break;
        case 4:
          printPost();
          break;
        default:
          validar = false;
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

    User usuarioSalvo = usuarioservice.salvarUserDB(user);
  }

  public static void Login() throws Exception {
    Scanner sc = new Scanner(System.in);

    System.out.print("E-mail: ");
    String email = sc.nextLine();
    System.out.print("Senha: ");
    String senha = sc.nextLine();

    // Verificar a autenticação no banco de dados
    User user = UsuarioService.autenticarUsuario(email, senha);
    if (user != null) {
      System.out.println("Login bem-sucedido! Bem-vindo, " + user.getName() + "!");
      boolean validar = true;
      while(validar == true){
        System.out.println("Logado com: " + GeneralState.loggedUser.getName());
        System.out.println("---- MENU ----");
        System.out.println("1 - Posts");
        System.out.println("2 - Editar Conta");
        System.out.println("3 - Excluir Conta");
        System.out.println("9 - LOGOUT");

        int menu = sc.nextInt();
        switch (menu) {
          case 1:
            Post();
            break;
          case 2:
            EditUser();
            break;
          case 9:
            validar = false;
            GeneralState.loggedUser = null;
        }
      }
    } else {
      System.out.println("E-mail ou senha inválidos. Tente novamente.");
    }
  }

  public static void EditUser() throws Exception {
    Scanner sc = new Scanner(System.in);
    User user = new User();
  }
  // -------------------------------------------------------------------------
  // ---------------------------- * POST METODS * ----------------------------
  // -------------------------------------------------------------------------

  public static void AddPost(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o Titulo do Post");
    String title = sc.nextLine();
    System.out.println("Digite o conteúdo do Post");
    String content = sc.nextLine();

    if (DatabaseMemo.postArrayList.add(new Post(title, content, GeneralState.loggedUser))) {
      System.out.println("-------------------------------------");
      System.out.println(Message.POST_SUCCESS);
      System.out.println("-------------------------------------");
    } else {
      System.out.println("-------------------------------------");
      System.out.println(Message.POST_FAIL);
      System.out.println("-------------------------------------");
    }
  }

  public static void deletePost(int idToDelete) {
    for(int i = 0; i < DatabaseMemo.postArrayList.size(); i++) {
      Post post = DatabaseMemo.postArrayList.get(i);
      if(post.getId().equals(idToDelete) && post.getUser().equals(GeneralState.loggedUser)) {
        DatabaseMemo.postArrayList.remove(post);
        System.out.println("-------------------------------------");
        System.out.println(Message.POST_EXCLUIR);
        System.out.println("-------------------------------------");
      } else if(!post.getUser().equals(GeneralState.loggedUser) && post.getId().equals(idToDelete)) {
        System.out.println("-------------------------------------");
        System.out.println(Message.POST_EXCLUIR_FAILED);
        System.out.println("-------------------------------------");
      }
    }
  }

  public static void editPost(int idToEdit) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < DatabaseMemo.postArrayList.size(); i++) {
      Post post = DatabaseMemo.postArrayList.get(i);
      if (post.getId().equals(idToEdit) && post.getUser().equals(GeneralState.loggedUser)) {
        System.out.println("Novo título do post: ");
        String newTitle = sc.nextLine();
        System.out.println("Novo conteúdo do post: ");
        String newContent = sc.nextLine();

        post.setTitle(newTitle);
        post.setContents(newContent);
        System.out.println("-------------------------------------");
        System.out.println(Message.POST_EDIT_SUCCESS);
        System.out.println("-------------------------------------");
      }
    }
    System.out.println("-------------------------------------");
    System.out.println(Message.POST_EDIT_FAILED);
    System.out.println("-------------------------------------");
  }

  public static void printPost(){
    for(int i = 0; i < DatabaseMemo.postArrayList.size(); i++) {
      Post post = DatabaseMemo.postArrayList.get(i);
      System.out.println("-----------------------------------------------");

      System.out.println(post.getTitle());
      System.out.println(post.getContents());
      System.out.println(" ");
      System.out.println("Postado por: " + post.getUser().getName());
      System.out.println("ID do post: " + post.getId());

      System.out.println("-----------------------------------------------");

    }
  }
}



// Requisitos mínimos de entrega
//
// mínimo uma classe abstrata ✅
// 2 interfaces ✅
// 1 enum ✅
// 3 collections (3 do mesmo tipo ou mescladas)
// deve possuir herança e polimorfismo ✅
// todos os atributos devem ser encapsulados (a menos que haja alguma exceção) ✅
// deve ter ao menos 3 CRUD (em listas) ✅
//=======
//>>>>>>> Stashed changes
