package com.accenture.tq.desafiotqvueloshoteles.controller;

import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationInputDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationDetailsDTO;
import com.accenture.tq.desafiotqvueloshoteles.service.flightReservation.FlightReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/flight-reservation")
public class FlightReservationController {
  @Autowired
  private FlightReservationService flightReservationService;

  @PostMapping
  public ResponseEntity<FlightReservationDetailsDTO> createFlightReservation(
      @RequestBody FlightReservationInputDTO flightReservation) {
    String username = flightReservation.getUsername();
    if (username == null || username.trim().isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    FlightReservationDetailsDTO createdFlightReservation = flightReservationService.createFlightReservation(username, flightReservation);
    return ResponseEntity.ok(createdFlightReservation);
  }
}
