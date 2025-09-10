package com.accenture.tq.desafiotqvueloshoteles.repository;

import com.accenture.tq.desafiotqvueloshoteles.model.entities.booking.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
  List<HotelBooking> findByHotelId(Long hotelId);
  
}
