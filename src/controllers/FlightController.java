package controllers;

import entities.Flight;
import repositories.interfaces.IFlightRepository;
import repositories.FlightRepository;

import java.util.List;

public class FlightController {
    private final IFlightRepository repo;

    public FlightController(IFlightRepository repo) {
        this.repo = repo;
    }

    public String getAllFlights() {
        List<Flight> flights = repo.getAllFlights();

        return flights.toString();
    }
    public Flight getFlight(int id){
        Flight flight = repo.getFlight(id);
        return flight;
    }

}
