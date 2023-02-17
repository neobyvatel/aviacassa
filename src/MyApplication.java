
import controllers.UserController;
import entities.User;
import controllers.FlightController;
import entities.Flight;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private User user;
    private boolean isActive = false;
    private final UserController userController;
    private final FlightController flightController;
    private final Scanner scanner;

    public MyApplication(UserController userController, FlightController flightController) {
        this.userController = userController;
        this.flightController = flightController;

        scanner = new Scanner(System.in);
    }

    public static void clearConsole() {
        System.out.println("\\033[H\\033[2J");
        System.out.flush();
    }

    public void getAllUsersMenu() {
        String response = userController.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = userController.getUser(id);
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

        String response = userController.register(name, surname,email, balance);
        System.out.println(response);
    }

    public void loginMenu(){
        System.out.println("Please enter email");
        String email = scanner.next();
        user = userController.login(email);
        String response = user == null ? "User was not found!" : "Welcome to AviaCassa, " + user.getEmail();
        System.out.println(response);
        isActive = true;
    }

    public void getAllFlightsMenu(){
        String response = flightController.getAllFlights();
        System.out.println(response);
    }

    public void purchaseFlightMenu(){
        getAllFlightsMenu();
        System.out.println("Select flight:");
        int option = scanner.nextInt();
        Flight flight = flightController.getFlight(option);
        String response = userController.getASeat(flight);
        System.out.println(response);
    }

    public void start() {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("0. Exit");
            System.out.println();
        while (!isActive) {
            try {
                System.out.print("Enter option (1-2): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    loginMenu();
                    isActive = true;
                } else if (option == 2) {
                    registerMenu();
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

        System.out.println("Hello " +  user.getName() + ' ' + user.getSurname());
        System.out.println("----------------------------------------------");

        while (isActive){
            try {
                System.out.println("Select option:");
                System.out.println("1. Display flights");
                System.out.println("2. Choose flight");
                System.out.println("3. Current balance");
                System.out.print("Enter option (1-2): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllFlightsMenu();
                }
                else if (option == 2) {
                    purchaseFlightMenu();
                }
                else if (option == 3) {
                    System.out.println("Your current balance is " + user.getBalance());
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
    }


}
