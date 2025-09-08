package com.accenture.tq.desafiotqvueloshoteles.dto.hotel;

import lombok.*;

@Data
public class HotelDTOOutput {
  private Long id;
  private String hotelCode;
  private String city;
  private String country;
  private String street;
  private String zipCode;
}
