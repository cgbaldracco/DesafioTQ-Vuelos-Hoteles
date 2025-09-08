package com.accenture.tq.desafiotqvueloshoteles.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class HotelDTOOutput {
  private String city;
  private String country;
  private String street;
  private String zipCode;
}
