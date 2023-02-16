package entities;


public class Flight {
        private int id;

        private String origin;

        private String destination;

        private int price;

        private int seats;

        public Flight(){}

        public Flight(String origin, String destination, int price, int seats){
                setOrigin(origin);
                setDestination(destination);
                setPrice(price);
                setSeats(seats);
        }

        public Flight(int id, String origin, String destination, int price, int seats){
                this(origin, destination, price, seats);
                setId(id);
        }


        public void setId(int id) {
                this.id = id;
        }

        public void setOrigin(String origin) {
                this.origin = origin;
        }

        public String getOrigin() {
                return origin;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public int getPrice() {
                return price;
        }

        public void setDestination(String destination) {
                this.destination = destination;
        }

        public String getDestination() {
                return destination;
        }

        public int getSeats() {
                return seats;
        }

        public void setSeats(int seats) {
                this.seats = seats;
        }

        @Override
        public String toString() {
                return "Flight{" +
                        "id=" + id +
                        ", origin='" + origin + '\'' +
                        ", destination='" + destination + '\'' +
                        ", price=" + price +
                        ", seats=" + seats +
                        '}';
        }

        public static boolean checkSeat(int seats) {
                return (seats>0);
        }

}
