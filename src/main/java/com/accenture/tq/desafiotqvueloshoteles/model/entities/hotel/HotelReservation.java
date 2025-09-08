package com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "HotelReservation")
public class HotelReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private HotelRoom hotelRoom;
    private Date dateFrom;
    private Date dateTo;

}
