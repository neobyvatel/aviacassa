package repositories;

import data.interfaces.IDB;
import entities.User;
import entities.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserFlightRepository extends UserRepository{
    private IDB db;

    public UserFlightRepository(IDB db) {
        this.db = db;
    }

    public boolean getASeat(User user, Flight flight) {

        Connection con = null;

        int seats = flight.getSeats();
        int price = flight.getPrice();
        int balance = user.getBalance();

        int userId = user.getId();
        int flightId = flight.getId();

        ArrayList<Flight> flights = user.getFlights();

        int remaining = balance - price;
        int updatedSeats = seats - 1;

        String flightOrigDest = flight.getOrigDest();

        if (seats > 0) {
            if (remaining > 0) {
                flight.setSeats(updatedSeats);
                user.setBalance(remaining);
                flights.add(flight);
                user.setFlights(flights);
            } else System.out.println("Insufficient balance");
        }else System.out.println("No seats avalable!");

        try {
            con = db.getConnection();
            String UserSQL = "UPDATE users SET balance = ?, flights = ? WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(UserSQL);

            st.setInt(1, remaining);
            st.setString(2,flightOrigDest);
            st.setInt(3, userId);

            st.execute();

            String flightSQL = "UPDATE flights SET seats = ? WHERE flight_id = ?";
            PreparedStatement flightST = con.prepareStatement(flightSQL);
            flightST.setInt(1,updatedSeats);
            flightST.setInt(2, flightId);

            flightST.execute();

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
}
