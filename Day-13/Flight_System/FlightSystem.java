package Flight_System;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightSystem {
    public static void main(String[] args) {
        try {
            Flight flight1 = new Flight(01, "bombay", "delhi", 10);
//            flight.addFlight(flight);
            ReservationSystem reservationSystem = new ReservationSystem();
            ReservationSystem.flightDB(flight1.getFlightNumber(), flight1.getAvailableSeats());
//            ReservationSystem.flightDB(12555, 2);

            reservationSystem.booking(01, 2);
//            System.out.println();
            System.out.println(reservationSystem.check(01));
//            reservationSystem.booking(01);
//            reservationSystem.booking(123); //// Attempt to book again
        } catch (ReservationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
