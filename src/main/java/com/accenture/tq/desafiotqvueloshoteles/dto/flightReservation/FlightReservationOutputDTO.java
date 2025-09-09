package com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation;

import com.accenture.tq.desafiotqvueloshoteles.dto.general.PeopleDTO;
import lombok.Data;
import java.util.List;

@Data
public class FlightReservationOutputDTO {
  private String dateFrom;
  private String dateTo;
  private String origin;
  private String destination;
  private String flightNumber;
  private Integer seats;
  private String seatType;
  private List<PeopleDTO> people;
}
