import entities.User;

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
                        sc.nextLine();
                        System.out.println("E-mail");
                        String email = sc.nextLine();
                        System.out.println("Password");
                        String password = sc.nextLine();
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.println("E-mail");
                        String email1 = sc.nextLine();
                        System.out.println("Password");
                        String password1 = sc.nextLine();
                        System.out.println("Nome Completo");
                        String name = sc.nextLine();
                        System.out.println("Data de Nascimento");
                        String birthdate = sc.nextLine();
                        System.out.println("Estado Cívil");
                        String relationship = sc.nextLine();
                        break;
                }
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

