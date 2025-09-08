package com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class HotelRoom {
  private Long id;
  private Hotel hotel;
  private String roomType;
  private boolean hasService;
}
