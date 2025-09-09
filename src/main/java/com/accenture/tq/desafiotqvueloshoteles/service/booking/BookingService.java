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

  /**
   * Crea una reserva de hotel con los datos recibidos.
   * @param username
   * @param booking
   * @return Detalles de la reserva creada que incluyen el precio de la misma.
   */
  public BookingDetailsDTOOutput createBooking(String username, BookingDetailsDTOInput booking) {
    // Lógica para crear una reserva
    return null; // Retorna el objeto BookingDetailsDTOOutput correspondiente
  }

  /**
   * Metodo que elimina la reserva de hotel correspondiente al id recibido.
   * Lo elimina permanentemente del repositorio.
   * @param bookingId
   * @return id de reserva eliminada.
   */
  @Override
  public Long deleteBooking(Long bookingId) {
    hotelBookingRepository.deleteById(bookingId);
    return bookingId;
  }
}
