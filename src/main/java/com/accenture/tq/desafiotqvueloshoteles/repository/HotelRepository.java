package com.accenture.tq.desafiotqvueloshoteles.repository;

import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
