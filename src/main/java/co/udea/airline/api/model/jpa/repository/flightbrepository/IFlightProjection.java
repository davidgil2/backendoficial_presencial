package co.udea.airline.api.model.jpa.repository.flightbrepository;

public interface IFlightProjection {
    String getFlightNumber();
    String getFlightType();
    String getOriginCity();
    String getDestinationCity();
    String getDepartureDate();
    String getArrivalDate();
}
