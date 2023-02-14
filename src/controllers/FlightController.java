package controllers;

import entities.Flight;
import repositories.interfaces.IFlightRepository;


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
}
