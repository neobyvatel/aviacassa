package entities;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int balance;
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public User() {
    }

    public User(String name, String surname, String email, Integer balance) {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setBalance(balance);

    }
    public void addBalance(int amount) { setBalance(balance + amount); }
    public User(int id, String name, String surname, String email, int balance) {
        this(name, surname,email, balance);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", flights=" + flights +
                '}';
    }
}
