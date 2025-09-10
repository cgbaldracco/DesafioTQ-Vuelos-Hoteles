package com.accenture.tq.desafiotqvueloshoteles.controller;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {
  @Autowired
  private HotelService hotelService;

  @GetMapping
  public ResponseEntity<List<HotelDTOOutput>> getAvailableHotels(
      @RequestParam(required = false) Date dateFrom,
      @RequestParam(required = false) Date dateTo,
      @RequestParam(required = false) String destination) {
    List<HotelDTOOutput> availableHotels = hotelService.getAvailableHotels(dateFrom, dateTo, destination);
    return ResponseEntity.ok(availableHotels);
  }

}
