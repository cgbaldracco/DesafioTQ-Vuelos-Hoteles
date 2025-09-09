package com.accenture.tq.desafiotqvueloshoteles.model.entities.flightReservation;

import com.accenture.tq.desafiotqvueloshoteles.model.entities.general.PaymentMethod;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.general.People;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class FlightReservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userName;
  private Date dateFrom;
  private Date dateTo;
  private String origin;
  private String destination;
  private String flightNumber;
  private Integer seats;
  private String seatType;
  private BigInteger totalAmount;

  @OneToMany(cascade = CascadeType.ALL)
  private List<People> people;

  @OneToOne(cascade = CascadeType.ALL)
  private PaymentMethod paymentMethod;
}
