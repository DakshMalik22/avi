package Flight_System;

import java.util.ArrayList;

class Flight {
    // ArrayList to store flights
    ArrayList<Flight> flights = new ArrayList<>();

    private int flightNumber;
    private String departureCity;
    private String destinationCity;
    private int availableSeats;

    // Default constructor
    public Flight() {
    }

    // Parameterized constructor
    public Flight(int flightNumber, String departureCity, String destinationCity, int availableSeats) throws ReservationException {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.availableSeats = availableSeats;
        if (availableSeats < 0) {
            throw new ReservationException("Seats can't be zero");
        }
    }

    // Method to add a flight to the flights list
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    // Getter method for availableSeats
    public int getAvailableSeats() {
        return availableSeats;
    }

    // Getter method for flightNumber
    public int getFlightNumber() {
        return flightNumber;
    }

    // Getter method for departureCity
    public String getDepartureCity() {
        return departureCity;
    }

    // Getter method for destinationCity
    public String getDestinationCity() {
        return destinationCity;
    }
}
