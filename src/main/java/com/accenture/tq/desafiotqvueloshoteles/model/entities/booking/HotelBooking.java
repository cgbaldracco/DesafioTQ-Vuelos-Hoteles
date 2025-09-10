package com.accenture.tq.desafiotqvueloshoteles.model.entities.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hotel_booking")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class HotelBooking {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String userName;
  private Long hotelId;
  private Date dateFrom;
  private Date dateTo;
  private int peopleAmount;
  private String roomType;
  @ElementCollection
  private List<People> people;
}
