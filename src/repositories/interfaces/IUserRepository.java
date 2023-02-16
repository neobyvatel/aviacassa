package repositories.interfaces;

import entities.User;
import entities.Flight; 

import java.util.List;

public interface IUserRepository {
    boolean register(User user);
    User login(String email);
    boolean getASeat(User user, Flight flight, int seat);
    User getUser(int id);
    List<User> getAllUsers();
}
