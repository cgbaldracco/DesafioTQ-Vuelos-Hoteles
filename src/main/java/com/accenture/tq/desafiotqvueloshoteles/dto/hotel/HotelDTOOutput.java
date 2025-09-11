package com.accenture.tq.desafiotqvueloshoteles.dto.hotel;

import lombok.*;
import java.math.BigInteger;
import java.util.Date;

@Data
public class HotelDTOOutput {
  private Long id;
  private String hotelCode;
  private String hotelName;
  private String city;
  private String roomType;
  private BigInteger amountPerNight;
  private Date availableFrom;
  private Date availableTo;
  private boolean isReserved;
}
