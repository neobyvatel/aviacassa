package controllers;

import entities.Flights;
import repositories.interfaces.IFlightRepository;
import repositories.interfaces.IUserRepository;

public class FlightController {
    private final IFlightRepository repo;

    public FlightController(IFlightRepository repo) {
        this.repo = repo;
    }
}
