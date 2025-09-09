package com.accenture.tq.desafiotqvueloshoteles.repository;

import com.accenture.tq.desafiotqvueloshoteles.model.entities.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
