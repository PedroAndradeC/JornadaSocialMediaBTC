import com.beyondthecode.database.DatabaseMemo;
import com.beyondthecode.entities.Post;
import com.beyondthecode.entities.User;
import com.beyondthecode.enums.Message;

import java.util.Optional;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int menu;
    boolean validar = true;
    while (validar == true) {
      System.out.println("Bem vindo ao BTC");
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
          System.out.println(DatabaseMemo.userArrayList);
          break;
        default:
          validar = false;
      }
    }
  }

  public static void createUser() {
    Scanner sc = new Scanner(System.in);

    System.out.println("E-mail");
    String email = sc.nextLine();
    System.out.println("Password");
    String password = sc.nextLine();
    System.out.println("Nome Completo");
    String name = sc.nextLine();

    Optional<User> filteredEmail = DatabaseMemo.userArrayList.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    if(filteredEmail.isEmpty()) {
      DatabaseMemo.userArrayList.add(new User(email, password, name));
      System.out.println(Message.REGISTER_SUCCESS);
    } else {
      System.out.println(Message.REGISTER_FAIL);
    }
  }

  public static void Login() {
    Scanner sc = new Scanner(System.in);

    System.out.println("E-mail");
    String email = sc.nextLine();
    System.out.println("Password");
    String password = sc.nextLine();

    Optional<User> filteredUser = DatabaseMemo.userArrayList.stream().filter(user -> user.getEmail().equals(email)
            && user.getPassword().equals(password)).findFirst();

    if(filteredUser.isPresent()) {
      System.out.println(Message.LOGIN_SUCCESS);
      //Local de continuar código
      //Segundo Menu
      boolean validar = true;
      while(validar == true){
        System.out.println("- MENU -");
        System.out.println("1 - Posts");
        System.out.println("2 - Encontrar Amigos");
        System.out.println("3 - Ambiente de aprendizagem");
        System.out.println("4 - Lobby da Gameplay");
        System.out.println("9 - LOGOUT");

        int menu = sc.nextInt();
        switch (menu) {
          case 1:
            Post();
            break;
          case 2:
            break;
          default:
            validar = false;
        }
      }
    } else {
      System.out.println(Message.LOGIN_FAIL);
    }
  }
  public static void Post() {
    Scanner sc = new Scanner(System.in);
    boolean validar = true;
    while(validar == true){
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
          System.out.println(Message.POST_CHANGE);
          break;
        case 3:
          System.out.println("Digite o ID do post que deseja deletar: ");
          int idToDelete = sc.nextInt();
          deletePost(idToDelete);
          System.out.println(Message.POST_EXCLUIR);
          break;
        case 4:
          printPost();
          break;
        default:
          validar = false;
      }
    }
  }
  public static void AddPost(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o Titulo do Post");
    String title = sc.nextLine();
    System.out.println("Digite o conteúdo do Post");
    String content = sc.nextLine();

    DatabaseMemo.postArrayList.add(new Post(title, content));
  }

  public static void deletePost(int idToDelete) {
    for(int i = 0; i < DatabaseMemo.postArrayList.size(); i++) {
      Post post = DatabaseMemo.postArrayList.get(i);
      if(post.getId().equals(idToDelete)) {
        DatabaseMemo.postArrayList.remove(post);
      }
    }
  }


  public static void printPost(){
    for(int i = 0; i < DatabaseMemo.postArrayList.size(); i++) {
      Post post = DatabaseMemo.postArrayList.get(i);
      System.out.println("-----------------------------------------------");
      System.out.println(" ");

      System.out.println(post.getTitle());
      System.out.println(post.getContents());
      System.out.println("ID do post: " + post.getId());

      System.out.println(" ");
      System.out.println("-----------------------------------------------");

    }
  }
}



// Requisitos mínimos de entrega
//
// mínimo uma classe abstrata
// 2 interfaces
// 1 enum
// 3 collections (3 do mesmo tipo ou mescladas)
// deve possuir herança e polimorfismo
// todos os atributos devem ser encapsulados (a menos que haja alguma exceção)
// deve ter ao menos 3 CRUD (em listas)