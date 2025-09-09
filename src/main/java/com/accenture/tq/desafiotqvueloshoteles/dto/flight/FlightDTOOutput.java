package com.accenture.tq.desafiotqvueloshoteles.dto.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTOOutput {
    private String flightNumber;
    private String origin;
    private String destination;
    private String seatType;
    private Double amount;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public FlightDTOOutput(String flightNumber, String origin, String destination, String seatType, Double amount, LocalDate dateFrom, LocalDate dateTo) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.seatType = seatType;
        this.amount = amount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public FlightDTOOutput() {}

    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setSeatType(String seatType) { this.seatType = seatType; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setDateFrom(LocalDate dateFrom) { this.dateFrom = dateFrom; }
    public void setDateTo(LocalDate dateTo) { this.dateTo = dateTo; }

    public String getFlightNumber() {
        return flightNumber;
    }
}