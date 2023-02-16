package controllers;

import entities.User;
import entities.Flight;
import repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;
    private User loggedInUser = null; 

    public UserController(IUserRepository repo) {
        this.repo = repo;
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

    // should be called from MyApplication using getFlight 
    public String getASeat(Flight flight, int seat) {
        String message = "The purchase has failed!";
        if (loggedInUser != null) {
            if (repo.getASeat(loggedInUser, flight, seat)) {
                message = "You have successfully bought a seat!";
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
