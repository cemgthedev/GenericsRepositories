package app;

import java.util.Scanner;

import app.types.InMemoryRepository;
import app.types.User;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<User> repository = new InMemoryRepository<>();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("1. Adicionar");
            System.out.println("2. Atualizar");
            System.out.println("3. Remover");
            System.out.println("4. Buscar");
            System.out.println("5. Buscar todos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();

            switch(option) {
                case 1:
                    User user = new User();
                    System.out.print("Nome: ");
                    user.setName(scanner.next());
                    System.out.print("Email: ");
                    user.setEmail(scanner.next());
                    System.out.print("Senha: ");
                    user.setPassword(scanner.next());
                    System.out.print("CPF: ");
                    user.setCpf(scanner.next());
                    System.out.print("Idade: ");
                    user.setAge(scanner.nextInt());
                    String generatedId = repository.save(user);
                    System.out.println("Id gerado: " + generatedId);

                    user.setId(generatedId);
                    repository.update(generatedId, user);
                    break;
                case 2:
                    System.out.print("Id: ");
                    String id = scanner.next();
                    user = new User();
                    System.out.print("Nome: ");
                    user.setName(scanner.next());
                    System.out.print("Email: ");
                    user.setEmail(scanner.next());
                    System.out.print("Senha: ");
                    user.setPassword(scanner.next());
                    System.out.print("CPF: ");
                    user.setCpf(scanner.next());
                    System.out.print("Idade: ");
                    user.setAge(scanner.nextInt());
                    repository.update(id, user);
                    break;
                case 3:
                    System.out.print("Id: ");
                    id = scanner.next();
                    repository.delete(id);
                    break;
                case 4:
                    System.out.print("Id: ");
                    id = scanner.next();
                    user = repository.findById(id);
                    System.out.println(user);
                    break;
                case 5:
                    repository.findAll().forEach(System.out::println);
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
