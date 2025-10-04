import java.util.*;

class Flight {
    String flightNumber;
    String origin;
    String destination;
    int seatsAvailable;
    double price;

    public Flight(String flightNumber, String origin, String destination, int seatsAvailable, double price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Flight Number: " + flightNumber +
                           ", From: " + origin +
                           ", To: " + destination +
                           ", Seats: " + seatsAvailable +
                           ", Price: $" + price);
    }
}

class Booking {
    String passengerName;
    Flight flight;

    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public void confirmBooking() {
        System.out.println("\n✅ Booking Confirmed!");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Flight Number: " + flight.flightNumber);
        System.out.println("From: " + flight.origin + " To: " + flight.destination);
        System.out.println("Price Paid: $" + flight.price);
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample flight data
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AI101", "New York", "London", 5, 500.0));
        flights.add(new Flight("BA202", "Paris", "Tokyo", 3, 750.0));
        flights.add(new Flight("DL303", "Los Angeles", "Dubai", 2, 680.0));

        System.out.println("✈️ Welcome to Flight Booking System");

        // Show flights
        System.out.println("\nAvailable Flights:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.print((i + 1) + ". ");
            flights.get(i).displayInfo();
        }

        // Choose a flight
        System.out.print("\nEnter flight number to book (1-" + flights.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice < 1 || choice > flights.size()) {
            System.out.println("❌ Invalid choice. Exiting.");
            return;
        }

        Flight selectedFlight = flights.get(choice - 1);

        // Check availability
        if (selectedFlight.seatsAvailable <= 0) {
            System.out.println("❌ Sorry, no seats available on this flight.");
            return;
        }

        // Get passenger name
        System.out.print("Enter passenger name: ");
        String passengerName = scanner.nextLine();

        // Book ticket
        selectedFlight.seatsAvailable--;
        Booking booking = new Booking(passengerName, selectedFlight);
        booking.confirmBooking();

        scanner.close();
    }
}

