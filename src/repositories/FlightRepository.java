package repositories;

import data.interfaces.IDB;
import entities.Flights;
import repositories.interfaces.IFlightRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FlightRepository {
    private final IDB db;

    public FlightRepository(IDB db) {
        this.db = db;
    }
}
