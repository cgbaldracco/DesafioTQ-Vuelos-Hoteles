package com.accenture.tq.desafiotqvueloshoteles.repository;

import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {
  List<HotelReservation> findByHotel(Hotel hotel);
}
