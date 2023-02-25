package repositories;

import data.interfaces.IDB;
import entities.User;
import entities.Flight;
import repositories.interfaces.IUserRepository;
import repositories.FlightRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class UserRepository implements IUserRepository {
    private IDB db;
    public UserRepository(){
    }

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean register(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(firstname,lastname,email,balance) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setString(3, user.getEmail());
            st.setInt(4, user.getBalance());

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
    public User login(String email){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, email);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("user_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getInt("balance"));

                return user;
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
    public User getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,email,balance FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getInt("balance"));

                return user;
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
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<User> users = new LinkedList<>();

            while (rs.next()) {
                User user = new User(rs.getInt("user_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getInt("balance")
                );
                users.add(user);
            }
            return users;
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

    public boolean addBalance(User user, int amount) {
        int balance = user.getBalance();
        int currentBalance = balance + amount;
        int userId = user.getId();
        user.setBalance(currentBalance);

        Connection con = null;

        try {
            con = db.getConnection();
            String UserSQL = "UPDATE users SET balance = ? WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(UserSQL);

            st.setInt(1, balance);
            st.setInt(2, userId);

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
}
