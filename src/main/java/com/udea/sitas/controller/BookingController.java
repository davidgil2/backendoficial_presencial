package com.udea.sitas.controller;

import com.udea.sitas.model.Booking;
import com.udea.sitas.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
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

    @PostMapping
    public void saveBooking(@RequestBody Booking booking) {
        bookingService.saveOrUpdate(booking);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId){
        bookingService.delete(bookingId);
    }
}
