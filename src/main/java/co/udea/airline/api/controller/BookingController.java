package co.udea.airline.api.controller;

import co.udea.airline.api.model.jpa.model.bookings.Booking;
import co.udea.airline.api.services.bookingservices.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

    @GetMapping("/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBooking(bookingId);
    }

    @PostMapping("/booking")
    public void saveBooking(@RequestBody Booking booking) {
        bookingService.saveOrUpdate(booking);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId){
        bookingService.delete(bookingId);
    }

}
