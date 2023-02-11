package repositories.interfaces;

import entities.Flights;
import entities.User;

import java.util.List;

public interface IFlightRepository {
    boolean createFlight(Flights flight);
    Flights getFlight(int id);
    List<Flights> getAllFlights();
}
