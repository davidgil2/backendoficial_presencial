package co.udea.airline.api.controller;


import co.udea.airline.api.model.jpa.model.Booking_Passenger;
import co.udea.airline.api.service.BookingPassengerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/bookingPassenger")
@Tag(name = "Booking Passenger")
public class BookingPassengerController {

    @Autowired
    private BookingPassengerService bookingPassengerService;

    @GetMapping("/bookingsPassengers")
    public List<Booking_Passenger> getBookingsPassengers() {
        return bookingPassengerService.getBookingsPassengers();
    }

    @GetMapping("/{booking_passenger_id}")
    public Optional<Booking_Passenger> getBookingPassengerById(@PathVariable Long booking_passenger_id) {
        return bookingPassengerService.getBookingPassenger(booking_passenger_id);
    }

    @PostMapping("/bookingPassenger")
    public void saveFlight(@RequestBody Booking_Passenger bookingPassenger) {
        bookingPassengerService.saveOrUpdate(bookingPassenger);
    }

}
