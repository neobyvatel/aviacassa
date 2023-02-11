package entities;

public class Flights {
        private int id;


        private String origin;

        private String destination;

        private boolean FlightType;

        private int price;

        private int seats;

        public void setId() {
                this.id = id;
        }

        public void setOrigin(String origin) {
                this.origin = origin;
        }

        public String getOrigin() {
                return origin;
        }

        public void setFlightType(boolean flightType) {
                FlightType = flightType;
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

        public static boolean checkSeat(int seats) {
                return (seats>0);
        }

}
