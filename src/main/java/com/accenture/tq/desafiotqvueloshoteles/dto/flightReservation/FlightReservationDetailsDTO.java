package com.accenture.tq.desafiotqvueloshoteles.dto.flightReservation;

import com.accenture.tq.desafiotqvueloshoteles.dto.general.StatusCodeDTO;
import lombok.Data;
import java.math.BigInteger;

@Data
public class FlightReservationDetailsDTO {
  private String userName;
  private BigInteger amount;
  private BigInteger interest;
  private BigInteger total;
  private FlightReservationOutputDTO flightReservation;
  private StatusCodeDTO statusCode;
}
