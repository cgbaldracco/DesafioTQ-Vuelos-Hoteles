package com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Table(name = "HotelRoom")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Hotel hotel;
    private String roomType;
    private boolean hasService;

}
