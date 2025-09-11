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

}