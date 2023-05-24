import database.DatabaseMemo;
import entities.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int menu;

    while (true) {
      System.out.println("Bem vindo ao BTC");
      System.out.println("1 - Login");
      System.out.println("2 - Cadastro");
      menu = sc.nextInt();

      switch (menu) {
        case 1:
          Login();
          break;

        case 2:
          createUser();
          System.out.println(DatabaseMemo.userArrayList);
          break;
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
      System.out.println("Usuário cadastrado com sucesso!");
    } else {
      System.out.println("Email já cadastrado!");
    }
  }

  public static void Login() {
    Scanner sc = new Scanner(System.in);

    System.out.println("E-mail");
    String email = sc.nextLine();
    System.out.println("Password");
    String password = sc.nextLine();

    Optional<User> filteredUser = DatabaseMemo.userArrayList.stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).findFirst();

    if(filteredUser.isPresent()) {
      System.out.println("Login efetuado com sucesso!");
    } else {
      System.out.println("Email ou senha inválido!");
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