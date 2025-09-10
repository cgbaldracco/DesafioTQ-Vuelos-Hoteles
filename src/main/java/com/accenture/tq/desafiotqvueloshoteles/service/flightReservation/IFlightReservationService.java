package com.accenture.tq.desafiotqvueloshoteles.service.flightReservation;

import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationInputDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationDetailsDTO;

public interface IFlightReservationService {
  FlightReservationDetailsDTO createFlightReservation(String username,
                                                      FlightReservationInputDTO flightReservation);
}
