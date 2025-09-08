package com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class HotelReservation {
  private Long id;
  private Hotel hotel;
  private HotelRoom hotelRoom;
  private Date dateFrom;
  private Date dateTo;
}
