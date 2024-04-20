package co.udea.airline.api.model.jpa.repository.flightbrepository;

public interface IFlightDetailsProjection {
    String getFlightNumber();

    String getFlightType();

    String getOriginCity();

    String getDestinationCity();

    String getDepartureDate();

    String getArrivalDate();

    double getBasePrice();

    double getTaxPercent();

    double getSurcharge();

    String getAirplaneModel();

    int getCapacity();
}
