package controllers;

import entities.User;
import entities.Flight;
import repositories.UserFlightRepository;
import repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;
    private final UserFlightRepository userFlightRepo;
    private User loggedInUser = null; 

    public UserController(IUserRepository repo, UserFlightRepository userFlightRepo) {
        this.repo = repo;
        this.userFlightRepo = userFlightRepo;
    }

    public String register(String name, String surname, String email, int balance) {
        User user = new User(name, surname,email, balance);

        boolean created = repo.register(user);

        return (created ? "You have successfully registered!" : "Registration was failed!");
    }

    public User login(String email) {
        User user = repo.login(email);
        loggedInUser = user; 
        return user;
        //return (user == null ? "User was not found!" : "Welcome to AviaCassa, " + user.getEmail());
    }

    public String getASeat(Flight flight) {
        String message = "The purchase has failed!";
        if (loggedInUser != null  || flight == null) {
            if (userFlightRepo.getASeat(loggedInUser, flight)) {
                message = "You have successfully bought a seat!";
            }
        }

        return message;
    }

    public String addBalance(){
        String message = "The operation is failed!";
        if (loggedInUser != null ) {
            if (repo.addBalance(loggedInUser)) {
                message = "The balance has replenished!";
            }
        }
        return message;
    }


    public String getUser(int id) {
        User user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        return users.toString();
    }
}
