package repositories;

import data.interfaces.IDB;
import entities.Flight;
import entities.User;
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
            String sql = "INSERT INTO flights(origin,destination,price,seats) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, flight.getOrigin());
            st.setString(2, flight.getDestination());
            st.setInt(3, flight.getPrice());
            st.setInt(4, flight.getSeats());

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
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT flight_id ,origin,destination,price,seats FROM flights WHERE flight_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);


            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Flight flight = new Flight(rs.getInt("flight_id"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getInt("price"),
                        rs.getInt("seats"));
                return flight;
            }
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
        return null;
    }


    @Override
    public List<Flight> getAllFlights() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM flights";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Flight> flights = new LinkedList<>();

            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("flight_id"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getInt("price"),
                        rs.getInt("seats")
                );

                flights.add(flight);
            }
            return flights;
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
        return null;
    }
}
