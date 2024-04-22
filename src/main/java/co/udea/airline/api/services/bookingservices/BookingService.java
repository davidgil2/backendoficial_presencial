package co.udea.airline.api.services.bookingservices;

import co.udea.airline.api.model.jpa.model.bookings.Booking;
import co.udea.airline.api.model.jpa.repository.bookingrepository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    IBookingRepository bookingRepository;

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
