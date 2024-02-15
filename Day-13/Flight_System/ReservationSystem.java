package Flight_System;

import java.util.HashMap;

class ReservationSystem extends Flight {
    // HashMap to store flight numbers and available seats
    private static HashMap<Integer, Integer> map = new HashMap<>();

    // Default constructor
    public ReservationSystem() {
    }

    // Method to add flight to the reservation system database
    public static void flightDB(int number, int seats) {
        map.put(number, seats);
    }

    // Method to check available seats for a given flight number
    public int check(int number) {
        return map.get(number);
    }

    // Method to make a booking for a given flight number and seats
    public void booking(int number, int seats) throws ReservationException {
        if (map.containsKey(number)) {
            int availableSeats = map.get(number);
            if (availableSeats > 0 && availableSeats > seats) {
                map.put(number, availableSeats - seats);
                System.out.println("Your Booking is done");
            } else {
                throw new ReservationException("No seats available");
            }
        } else {
            throw new ReservationException("No such flight available");
        }
    }
}
