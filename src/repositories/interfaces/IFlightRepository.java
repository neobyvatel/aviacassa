package repositories.interfaces;

import entities.Flights;
import entities.User;

import java.util.List;

public interface IFlightRepository {
    boolean createFlight(User user);
    Flights getFlight(int id);
    List<Flights> getAllFlights();
}
