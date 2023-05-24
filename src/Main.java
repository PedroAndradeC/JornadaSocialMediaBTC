import entities.CheckLogin;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<User> usersList = new ArrayList<>();

        int menu = 0, loginUser = -1;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Bem vindo ao BTC");
            do {
                System.out.println("1 - Cadastro");
                System.out.println("2 - Login");
                menu = sc.nextInt();
                switch (menu) {
                    case 1:
                        sc.nextLine();
                        System.out.println("E-mail");
                        String email = sc.nextLine();
                        System.out.println("Password");
                        String password = sc.nextLine();
                        System.out.println("Nome Completo");
                        String name = sc.nextLine();
                        System.out.println("Data de Nascimento");
                        String birthdate = sc.nextLine();
                        System.out.println("Estado Cívil");
                        String relationship = sc.nextLine();
                        usersList.add(new User(email, password, name, birthdate, relationship));
                        break;

                    case 2:
                        sc.nextLine();
                        do {
                            System.out.println("E-mail");
                            String emailChecar = sc.nextLine();
                            System.out.println("Password");
                            String passwordChecar = sc.nextLine();
                            for (int i = 0; i < usersList.size(); i++){
                                if (usersList.get(i).getEmail().contentEquals(emailChecar)
                                        && usersList.get(i).getPassword().contentEquals(passwordChecar)) { // (contentEquals) String de comparação
                                    loginUser = i;
                                } else {
                                    System.out.println(CheckLogin.CHECK_LOGIN.getCheckLogin());
                                }
                                break;
                            }
                        } while (loginUser < 0);
                }
            } while (true);
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