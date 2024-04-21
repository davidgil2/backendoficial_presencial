package com.udea.vuelo.model;

public class Price {
    private int seatCost;
    private int flightCost;
    private int baggageCost;
    private int otherCosts;
    private int totalCost;

    public int getSeatCost() {
        return seatCost;
    }

    public void setSeatCost(int seatCost) {
        this.seatCost = seatCost;
    }

    public int getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(int flightCost) {
        this.flightCost = flightCost;
    }

    public int getBaggageCost() {
        return baggageCost;
    }

    public void setBaggageCost(int baggageCost) {
        this.baggageCost = baggageCost;
    }

    public int getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(int otherCosts) {
        this.otherCosts = otherCosts;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
