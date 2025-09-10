package com.accenture.tq.desafiotqvueloshoteles.service.helper;

import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationDetailsDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationInputDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationOutputDTO;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.flightReservation.FlightReservation;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.general.PaymentMethod;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.utils.DateParser;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.utils.FlightSeatPriceCalculator;
import org.modelmapper.ModelMapper;

public class FlightReservationHelper {
  private final DateParser dateParser = new DateParser();
  private final FlightSeatPriceCalculator priceCalculator = new FlightSeatPriceCalculator();
  private final ModelMapper modelMapper = new ModelMapper();

  /**
   * Metodo que transforma los datos enviados del front a una reserva de vuelo.
   * @param username
   * @param flightReservationInput
   * @return nueva reserva de vuelo
   */
  public FlightReservation createFlightReservationFromDTO(String username,
                                                           FlightReservationInputDTO flightReservationInput) {
    FlightReservation flightReservation = new FlightReservation();
    flightReservation.setUserName(username);
    flightReservation.setDateFrom(dateParser.parseDate(flightReservationInput.getDateFrom()));
    flightReservation.setDateTo(dateParser.parseDate(flightReservationInput.getDateTo()));
    flightReservation.setOrigin(flightReservationInput.getOrigin());
    flightReservation.setDestination(flightReservationInput.getDestination());
    flightReservation.setFlightNumber(flightReservationInput.getFlightNumber());
    flightReservation.setSeats(flightReservationInput.getSeats());
    flightReservation.setSeatType(flightReservationInput.getSeatType());
    flightReservation.setTotalAmount(priceCalculator.calculateFlightSeatPrice(flightReservationInput.getSeatType(),
        flightReservationInput.getSeats()));
    flightReservation.setPeople(flightReservationInput.getPeople()
        .stream().map(peopleDTO -> modelMapper.map(peopleDTO, People.class)).toList());
    flightReservation.setPaymentMethod(modelMapper.map(flightReservationInput.getPaymentMethod(), PaymentMethod.class));

    return flightReservation;
  }

  /**
   * Metodo que mapea una reserva de vuelo a un DTO de detalles de reserva de vuelo para ser devueltos
   * como informacion.
   * @param flightReservation
   * @return Detalles de la reserva de vuelo
   */
  public FlightReservationDetailsDTO mapToDetailsDTO(FlightReservation flightReservation) {
    FlightReservationDetailsDTO detailsDTO = new FlightReservationDetailsDTO();
    detailsDTO.setUserName(flightReservation.getUserName());
    detailsDTO.setAmount(flightReservation.getTotalAmount());
    detailsDTO.setInterest(priceCalculator.calculateFlightInterest(flightReservation.getSeatType(),
        flightReservation.getSeats()));
    detailsDTO.setTotal(detailsDTO.getAmount().add(detailsDTO.getInterest()));
    detailsDTO.setFlightReservation(modelMapper.map(flightReservation, FlightReservationOutputDTO.class));
    return detailsDTO;
  }
}
