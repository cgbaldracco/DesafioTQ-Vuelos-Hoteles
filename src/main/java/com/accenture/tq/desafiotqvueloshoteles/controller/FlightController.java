package com.accenture.tq.desafiotqvueloshoteles.controller;

import com.accenture.tq.desafiotqvueloshoteles.dto.flight.FlightDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.service.flight.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
	
    @Autowired
    private IFlightService flightService;

    @GetMapping("")
    public List<FlightDTOOutput> getAllFlights() {
        return flightService.getAllFlights();
    }

    /** Metodo que devuelve todos los vuelos disponibles dentro del rango de fechas recibido
	 * y que tengan de origen y destino las ciudades tambien recibidas.
	 * Si no se reciben parametros, devuelve todos los vuelos.
	 * @param dateFrom
	 * @param dateTo
	 * @param origin
	 * @param destination
	 * @return Lista de vuelos disponibles.
	 */
    @GetMapping(params = {"dateFrom", "dateTo", "origin", "destination"})
    public List<FlightDTOOutput> getAvailableFlights(
            @RequestParam(required = false) String dateFrom,
            @RequestParam(required = false) String dateTo,
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination) {
        return flightService.getAvailableFlights(dateFrom, dateTo, origin, destination);
    }
}