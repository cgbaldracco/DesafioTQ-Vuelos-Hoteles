package com.accenture.tq.desafiotqvueloshoteles.service.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOOutput;

public interface IBookingService {
  HotelBookingDTOOutput createBooking(HotelBookingDTOInput booking);

  Long deleteBooking(Long bookingId);
}