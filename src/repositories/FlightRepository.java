package repositories;

import data.interfaces.IDB;
import entities.Flight;
import repositories.interfaces.IFlightRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FlightRepository implements IFlightRepository{
    private final IDB db;

    public FlightRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createFlight(Flight flight) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO flights(origin,destination,seats,price) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, flight.getOrigin());
            st.setString(2, flight.getDestination());
            st.setInt(3, flight.getSeats());
            st.setInt(4, flight.getPrice());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Flight getFlight(int id) {
        return null;
    }

    @Override
    public List<Flight> getAllFlights() {
        return null;
    }
}
