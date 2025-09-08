package com.accenture.tq.desafiotqvueloshoteles.controller;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
  @Autowired
  private BookingService bookingService;

  @PostMapping("/api/v1/bookings")
  public ResponseEntity<BookingDetailsDTOOutput> createBooking(@RequestBody String username,
                                                               @RequestBody BookingDetailsDTOInput booking) {
    BookingDetailsDTOOutput createdBooking = bookingService.createBooking(username, booking);
    return ResponseEntity.ok(createdBooking);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Long> deleteBooking(@PathVariable Long id) {
    Long deletedId = bookingService.deleteBooking(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedId);
  }
}
