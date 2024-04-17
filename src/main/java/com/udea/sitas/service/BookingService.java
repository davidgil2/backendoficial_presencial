package com.udea.sitas.service;
import com.udea.sitas.model.Booking;
import com.udea.sitas.model.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBooking(Long id) {
        return bookingRepository.findById(id);
    }

    public void saveOrUpdate(Booking booking){
        bookingRepository.save(booking);
    }

    public void delete(Long id){
        bookingRepository.deleteById(id);
    }
}
