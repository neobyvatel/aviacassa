import java.util.concurrent.ConcurrentMap;
public class User {
    private int id;
    private static int id_n = 1;
    private String username;
    private String name;
    private String surname;
    private int balance;

    public User() {
        this.id = id_n++;
    }

    public User(Integer id, String username, String name, String surname, Integer balance) {
        this.id = id_n++;
        this.name = name;
        this.username = username;
        this.surname = surname;
        this.balance = balance;
    }

    public String getInfo() {
        return this.id + ". " + this.username + " " + this.name + " " + this.surname + " " + this.balance;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void getUsername(String username) {
        this.username = username;
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
}
