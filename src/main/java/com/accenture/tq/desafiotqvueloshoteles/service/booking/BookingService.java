package com.accenture.tq.desafiotqvueloshoteles.service.booking;

import com.accenture.tq.desafiotqvueloshoteles.service.helper.HotelBookingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.booking.HotelBooking;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelBookingRepository;

@Service
public class BookingService implements IBookingService {
	
	@Autowired
	private HotelBookingRepository hotelBookingRepository;

  private final HotelBookingHelper hotelBookingHelper = new HotelBookingHelper();

  /**
   * Metodo que crea una reserva de hotel a partir del DTO de entrada recibido.
   * Lo guarda en el repositorio y devuelve un DTO de salida con los datos de la reserva.
   * @param booking
   * @return
   */
	public HotelBookingDTOOutput createBooking(HotelBookingDTOInput booking) {
		HotelBooking bookingEntity = hotelBookingHelper.createBookingEntity(booking);
    hotelBookingRepository.save(bookingEntity);

		return hotelBookingHelper.createBookingOutputDTO(booking);
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