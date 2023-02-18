
import controllers.UserController;
import controllers.FlightController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.FlightRepository;
import repositories.UserFlightRepository;
import repositories.UserRepository;
import repositories.interfaces.IFlightRepository;
import repositories.interfaces.IUserRepository;


public class Main {


    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserRepository userRepo = new UserFlightRepository(db);
        IFlightRepository flightRepo = new FlightRepository(db);
        UserController userController = new UserController(userRepo);
        FlightController flightController = new FlightController(flightRepo);
        MyApplication app = new MyApplication(userController, flightController);
        app.start();

    }
}
