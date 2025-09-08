package com.accenture.tq.desafiotqvueloshoteles.service.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService implements IBookingService {
  @Autowired
  private HotelBookingRepository hotelBookingRepository;

  public BookingDetailsDTOOutput createBooking(String username, BookingDetailsDTOInput booking) {
    // Lógica para crear una reserva
    return null; // Retorna el objeto BookingDetailsDTOOutput correspondiente
  }

  @Override
  public Long deleteBooking(Long bookingId) {
    hotelBookingRepository.deleteById(bookingId);
    return bookingId;
  }
}
