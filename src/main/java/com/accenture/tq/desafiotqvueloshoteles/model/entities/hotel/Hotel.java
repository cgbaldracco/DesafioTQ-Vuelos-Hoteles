package com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Hotel {
  private Long id;
  private String city;
  private String country;
  private String street;
  private String zipCode;
  private List<HotelRoom> rooms;
}
