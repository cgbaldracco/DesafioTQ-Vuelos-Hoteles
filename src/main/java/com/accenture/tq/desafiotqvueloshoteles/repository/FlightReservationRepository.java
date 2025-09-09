package com.accenture.tq.desafiotqvueloshoteles.repository;

import com.accenture.tq.desafiotqvueloshoteles.model.entities.flightReservation.FlightReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightReservationRepository extends JpaRepository<FlightReservation, Long> {
}
