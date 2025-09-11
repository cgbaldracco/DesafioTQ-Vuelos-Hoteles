package com.accenture.tq.desafiotqvueloshoteles.model.entities.utils;

import java.math.BigInteger;

public class FlightSeatPriceCalculator {
  public BigInteger calculateFlightSeatPrice(String seatType, int seats) {
    BigInteger basePrice = switch (seatType) {
      case "BUSINESS" -> BigInteger.valueOf(250);
      case "FIRST" -> BigInteger.valueOf(400);
      default -> BigInteger.valueOf(100);
    };

    return basePrice.multiply(BigInteger.valueOf(seats));
  }

  public BigInteger calculateFlightInterest(String seatType, int seats) {
    if (seats > 2) {
      return switch (seatType) {
        case "BUSINESS" -> BigInteger.valueOf((long) 2.5);
        case "FIRST" -> BigInteger.valueOf((long) 1.5);
        default -> BigInteger.valueOf((long) 3.5);
      };
    } else {
      return switch (seatType) {
        case "BUSINESS" -> BigInteger.valueOf(3);
        case "FIRST" -> BigInteger.valueOf((long) 2);
        default -> BigInteger.valueOf((long) 4.5);
      };
    }
  }
}
