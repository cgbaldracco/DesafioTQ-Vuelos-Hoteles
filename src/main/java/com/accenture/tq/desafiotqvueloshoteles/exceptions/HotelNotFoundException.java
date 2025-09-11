package com.accenture.tq.desafiotqvueloshoteles.exceptions;

public class HotelNotFoundException extends RuntimeException {
  public HotelNotFoundException(String message) {
    super(message);
  }
}
