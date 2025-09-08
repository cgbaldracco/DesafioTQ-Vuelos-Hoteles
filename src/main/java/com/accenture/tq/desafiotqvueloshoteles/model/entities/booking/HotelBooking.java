package com.accenture.tq.desafiotqvueloshoteles.model.entities.booking;

import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.HotelRoom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class HotelBooking {
  private Long id;
  private String userName;
  private Long hotelId;
  private Date dateFrom;
  private Date dateTo;
  private int peopleAmount;
  private HotelRoom hotelRoom;
  private List<People> people;
}
