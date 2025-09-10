package com.accenture.tq.desafiotqvueloshoteles.controller;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
  @Autowired
  private BookingService bookingService;

  @PostMapping
  public ResponseEntity<HotelBookingDTOOutput> createBooking(@RequestBody HotelBookingDTOInput booking) {
    HotelBookingDTOOutput createdBooking = bookingService.createBooking(booking);
    return ResponseEntity.ok(createdBooking);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Long> deleteBooking(@PathVariable Long id) {
    Long deletedId = bookingService.deleteBooking(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedId);
  }
}
