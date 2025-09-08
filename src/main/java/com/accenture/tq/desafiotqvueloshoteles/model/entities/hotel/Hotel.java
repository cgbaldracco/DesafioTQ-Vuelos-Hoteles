package com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Hotel")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String country;
    private String street;
    private String zipCode;
    @OneToMany
    private List<HotelRoom> rooms;

}

