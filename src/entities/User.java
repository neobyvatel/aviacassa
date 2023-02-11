package entities;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String surname;
    private int balance;
    ArrayList<String> flights = new ArrayList<String>();

    public User() {

    }

    public User(String name, String surname) {
        setName(name);
        setSurname(surname);

    }

    public User(int id, String name, String surname, int balance) {
        this(name, surname);
        setId(id);
        setBalance(balance);
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance='" + balance +
                '}';
    }
}
