package com.accenture.tq.desafiotqvueloshoteles.service.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.BookingDetailsDTOOutput;

public interface IBookingService {
  BookingDetailsDTOOutput createBooking(String username, BookingDetailsDTOInput booking);

  Long deleteBooking(Long bookingId);
}
