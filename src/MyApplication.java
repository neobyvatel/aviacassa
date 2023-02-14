
import controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller;
    private final Scanner scanner;

    public MyApplication(UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public static void clearConsole() {
        System.out.println("\\033[H\\033[2J");
        System.out.flush();
    }

    public void start() {
        boolean isActive = false;
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
//            System.out.println("1. Get all users");
//            System.out.println("2. Get user by id");
//            System.out.println("3. Create user");
            System.out.println("0. Exit");
            System.out.println();
        while (isActive == false) {
            try {
                System.out.print("Enter option (1-2): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    loginMenu();
                    isActive = true;
                } else if (option == 2) {
                    registerMenu();
                } else if (option == 3) {

                } else {
                    break;
                }
            } catch (InputMismatchException r) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }

        while (isActive){

        }
    }

    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void registerMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter email");
        String email = scanner.next();
        System.out.println("Please enter balance");
        int balance = scanner.nextInt();

        String response = controller.register(name, surname,email, balance);
        System.out.println(response);
    }

    public void loginMenu(){
        System.out.println("Please enter email");
        String email = scanner.next();

        String response = controller.login(email);
        System.out.println(response);
    }
}
