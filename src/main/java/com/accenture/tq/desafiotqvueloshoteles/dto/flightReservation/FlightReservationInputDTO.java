package com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation;

import com.accenture.tq.desafiotqvueloshoteles.dto.general.PaymentMethodDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.general.PeopleDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Data
@Getter
@Setter
public class FlightReservationInputDTO {
  private String dateFrom;
  private String dateTo;
  private String origin;
  private String destination;
  private String flightNumber;
  private Integer seats;
  private String seatType;
  private List<PeopleDTO> people;
  private PaymentMethodDTO paymentMethod;
}
