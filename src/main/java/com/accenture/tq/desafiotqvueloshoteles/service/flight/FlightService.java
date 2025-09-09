package com.accenture.tq.desafiotqvueloshoteles.service.flight;

import com.accenture.tq.desafiotqvueloshoteles.dto.flight.FlightDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.flight.Flight;
import com.accenture.tq.desafiotqvueloshoteles.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {
	
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightDTOOutput> getAllFlights() {
        return flightRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private FlightDTOOutput toDTO(Flight flight) {
        FlightDTOOutput dto = new FlightDTOOutput();
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setOrigin(flight.getOrigin());
        dto.setDestination(flight.getDestination());
        dto.setSeatType(flight.getSeatType());
        dto.setAmount(flight.getAmount());
        dto.setDateFrom(flight.getDateFrom());
        dto.setDateTo(flight.getDateTo());
        return dto;
    }
}
