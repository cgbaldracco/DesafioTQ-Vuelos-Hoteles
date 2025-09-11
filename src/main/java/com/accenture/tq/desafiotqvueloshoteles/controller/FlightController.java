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

    @GetMapping("") //-- La ruta final sera /api/v1/flights
    public List<FlightDTOOutput> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(params = {"dateFrom", "dateTo", "origin", "destination"})
    public List<FlightDTOOutput> getAvailableFlights(
            @RequestParam String dateFrom,
            @RequestParam String dateTo,
            @RequestParam String origin,
            @RequestParam String destination) {
        return flightService.getAvailableFlights(dateFrom, dateTo, origin, destination);
    }
}