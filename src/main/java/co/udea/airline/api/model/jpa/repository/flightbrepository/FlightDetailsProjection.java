package co.udea.airline.api.model.jpa.repository.flightbrepository;

import org.springframework.stereotype.Component;

@Component
public class FlightDetailsProjection implements IFlightDetailsProjection {

    @Override
    public String getFlightNumber() {
        // Implementación para obtener el número de vuelo
        return null;
    }

    @Override
    public String getFlightType() {
        // Implementación para obtener el tipo de vuelo
        return null;
    }

    // Implementar todos los métodos de la interfaz IFlightDetailsProjection
    // Aquí deberías tener una implementación real para cada método

    @Override
    public String getOriginCity() {
        return null;
    }

    @Override
    public String getDestinationCity() {
        return null;
    }

    @Override
    public String getDepartureDate() {
        return null;
    }

    @Override
    public String getArrivalDate() {
        return null;
    }

    @Override
    public double getBasePrice() {
        return 0;
    }

    @Override
    public double getTaxPercent() {
        return 0;
    }

    @Override
    public double getSurcharge() {
        return 0;
    }

    @Override
    public String getAirplaneModel() {
        return null;
    }

    @Override
    public int getCapacity() {
        return 0;
    }
}

