package com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Hotel")
@Data
@Getter
public class Hotel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String hotelCode;
  private String hotelName;
  private String city;
  private String roomType;
  private BigInteger amountPerNight;
  private Date availableFrom;
  private Date availableTo;
  private Boolean isReserved;
}
