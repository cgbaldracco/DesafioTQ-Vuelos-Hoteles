package com.accenture.tq.desafiotqvueloshoteles.model.entities.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
  public Date parseDate(String date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    try {
      return dateFormat.parse(date);
    } catch (ParseException e) {
      throw new RuntimeException("Invalid date format", e);
    }
  }
}
