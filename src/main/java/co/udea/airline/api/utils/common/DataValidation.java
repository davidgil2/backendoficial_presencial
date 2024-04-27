package co.udea.airline.api.utils.common;

import co.udea.airline.api.model.jpa.model.flightbmodel.Scale;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;

public class DataValidation {

    public static void validateTimes(Scale scale) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime departureTime = scale.getDepartureDate();
        if (departureTime.isBefore(now)) {
            throw new IllegalArgumentException("No se puede eliminar el vuelo porque su fecha de partida es posterior a la fecha y hora actual");
        }
    }

  /**  public static void valiateBookings(Long id){
        long quantity = IBookingRepository.countByFlightId(id);
        if (quantity > 0) {
            throw new DataIntegrityViolationException("No se puede eliminar el vuelo con id: " + id + " porque tiene reservas asociadas");
        }
    }
**/
}
