package com.accenture.tq.desafiotqvueloshoteles.dto.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.general.StatusCodeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookingDetailsDTOOutput {
  private String userName;
  private BigInteger amount;
  private BigInteger interest;
  private BigInteger total;
  private HotelBookingDTOOutput booking;
  private StatusCodeDTO statusCode;
}
