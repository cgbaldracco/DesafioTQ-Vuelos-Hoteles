package com.accenture.tq.desafiotqvueloshoteles.service.flight;

import com.accenture.tq.desafiotqvueloshoteles.dto.flight.FlightDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.flight.Flight;
import com.accenture.tq.desafiotqvueloshoteles.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@Service
public class FlightService implements IFlightService {
	
    @Autowired
    private FlightRepository flightRepository;

    /**
	 * Metodo que devuelve todos los vuelos disponibles.
	 * @return Lista de vuelos disponibles.
	 */
    @Override
    public List<FlightDTOOutput> getAllFlights() {
    	List<FlightDTOOutput> result = flightRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    	if(result.isEmpty()) {
    		throw new IllegalArgumentException("No hay vuelos disponibles");
    	}
        return flightRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
     * Metodo que devuelve todos los vuelos disponibles dentro del rango de fechas recibido
     * y que tengan de origen y destino las ciudades tambien recibidas.
     * @param dateFrom
     * @param dateTo
     * @param origin
     * @param destination
     * @return Lista de vuelos disponibles.
     */
    @Override
    public List<FlightDTOOutput> getAvailableFlights(String dateFrom, String dateTo, String origin, String destination) {
        if(dateFrom == null || dateTo == null || origin == null || destination == null) {
            return getAllFlights();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate from;
        LocalDate to;
        try {
            from = LocalDate.parse(dateFrom, formatter);
            to = LocalDate.parse(dateTo, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de fecha debe ser DD/MM/AAAA");
        }
        if (from.isAfter(to)) {
            throw new IllegalArgumentException("La fecha de ida debe ser menor a la de vuelta.");
        }
        
        if (!flightRepository.existsByOrigin(origin)) {
            throw new IllegalArgumentException("El origen elegido no existe.");
        }
        if (!flightRepository.existsByDestination(destination)) {
            throw new IllegalArgumentException("El destino elegido no existe.");
        }
        List<Flight> flights = flightRepository.findAvailableFlights(from, to, origin, destination);
        if (flights.isEmpty()) {
            throw new IllegalArgumentException("No hay vuelos disponibles");
        }
        return flights.stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
	 * Metodo que convierte una entidad Flight a su DTO correspondiente.
	 * @param flight
	 * @return FlightDTOOutput
	 */
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