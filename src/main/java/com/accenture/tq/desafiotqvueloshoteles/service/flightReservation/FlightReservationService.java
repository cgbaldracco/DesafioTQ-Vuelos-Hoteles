package com.accenture.tq.desafiotqvueloshoteles.service.flightReservation;

import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationInputDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationDetailsDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation.FlightReservationOutputDTO;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.flightReservation.FlightReservation;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.general.PaymentMethod;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.general.People;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.utils.DateParser;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.utils.FlightSeatPriceCalculator;
import com.accenture.tq.desafiotqvueloshoteles.repository.FlightReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightReservationService implements IFlightReservationService {
  @Autowired
  private FlightReservationRepository flightReservationRepository;

  private final DateParser dateParser = new DateParser();
  private final FlightSeatPriceCalculator priceCalculator = new FlightSeatPriceCalculator();
  private final ModelMapper modelMapper = new ModelMapper();

  @Override
  public FlightReservationDetailsDTO createFlightReservation(String username,
                                                             FlightReservationInputDTO flightReservationInput) {
    FlightReservation flightReservation = createFlightReservationFromDTO(username, flightReservationInput);
    flightReservationRepository.save(flightReservation);

    return mapToDetailsDTO(flightReservation);
  }

  private FlightReservation createFlightReservationFromDTO(String username,
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

  private FlightReservationDetailsDTO mapToDetailsDTO(FlightReservation flightReservation) {
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
