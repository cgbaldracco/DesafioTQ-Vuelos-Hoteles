package com.accenture.tq.desafiotqvueloshoteles.service.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOOutput;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements IBookingService {
  public BookingDetailsDTOOutput createBooking(String username, BookingDetailsDTOInput booking) {
    // Lógica para crear una reserva
    return null; // Retorna el objeto BookingDetailsDTOOutput correspondiente
  }
}
