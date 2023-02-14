package controllers;

import entities.User;
import repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String register(String name, String surname, String email, int balance) {
        User user = new User(name, surname,email, balance);

        boolean created = repo.register(user);

        return (created ? "You have successfully registered!" : "Registration was failed!");
    }

    public String login(String email){
        User user = repo.login(email);

        return (user == null ? "User was not found!" : "Welcome to AviaCassa, " + user.getEmail());
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
