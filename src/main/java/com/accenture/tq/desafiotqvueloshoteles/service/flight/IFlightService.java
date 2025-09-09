package com.accenture.tq.desafiotqvueloshoteles.service.flight;

import com.accenture.tq.desafiotqvueloshoteles.dto.flight.FlightDTOOutput;
import java.util.List;

public interface IFlightService {
    List<FlightDTOOutput> getAllFlights();
}
