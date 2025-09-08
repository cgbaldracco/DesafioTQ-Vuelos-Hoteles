package com.accenture.tq.desafiotqvueloshoteles.model.exceptions;

public class HotelNotFoundException extends RuntimeException {
  public HotelNotFoundException(String message) {
    super(message);
  }
}
