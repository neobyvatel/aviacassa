package repositories.interfaces;

import entities.User;

import java.util.List;

public interface IUserRepository {
    boolean register(User user);
    User login(String email);

    User getUser(int id);
    List<User> getAllUsers();
}
