package repositories.interfaces;

import entities.Flight;
import entities.User;

import java.util.List;

public interface IFlightRepository {
    boolean createFlight(Flight flight);
    Flight getFlight(int id);
    List<Flight> getAllFlights();
}
