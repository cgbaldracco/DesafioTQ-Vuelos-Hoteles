package com.accenture.tq.desafiotqvueloshoteles.service.flightReservation;

import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationInputDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationDetailsDTO;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.flightReservation.FlightReservation;
import com.accenture.tq.desafiotqvueloshoteles.repository.FlightReservationRepository;
import com.accenture.tq.desafiotqvueloshoteles.service.helper.FlightReservationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightReservationService implements IFlightReservationService {
  @Autowired
  private FlightReservationRepository flightReservationRepository;

  private final FlightReservationHelper flightReservationHelper = new FlightReservationHelper();

  /**
   * Metodo utilizado para crear una reserva de vuelo, guardarla en el repositorio y
   * devolver los detalles de la reserva.
   * @param username
   * @param flightReservationInput
   * @return Detalles de la reserva de vuelo
   */
  @Override
  public FlightReservationDetailsDTO createFlightReservation(String username,
                                                             FlightReservationInputDTO flightReservationInput) {
    FlightReservation flightReservation = flightReservationHelper.
        createFlightReservationFromDTO(username, flightReservationInput);
    flightReservationRepository.save(flightReservation);

    return flightReservationHelper.mapToDetailsDTO(flightReservation);
  }
}
