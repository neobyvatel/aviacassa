package entities;

public class Flights {
        private int id;

        private static int id_n = 1;

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
        public void setFlightType(boolean flightType) {
                FlightType = flightType;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public void setDestination(String destination) {
                this.destination = destination;
        }

        public static boolean checkSeat(int seats) {
                return (seats>0);
        }

}
