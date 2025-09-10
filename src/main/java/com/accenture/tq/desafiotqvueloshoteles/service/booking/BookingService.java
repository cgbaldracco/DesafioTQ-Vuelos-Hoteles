package com.accenture.tq.desafiotqvueloshoteles.service.booking;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.StatusCodeDTO;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.booking.HotelBooking;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.booking.People;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelBookingRepository;

@Service
public class BookingService implements IBookingService {
	
	@Autowired
	private HotelBookingRepository hotelBookingRepository;

	public HotelBookingDTOOutput createBooking(HotelBookingDTOInput booking) {
		
		//-- Convertimos el DTO de entrada en entidad
		HotelBooking bookingEntity = new HotelBooking();
		bookingEntity.setUserName(booking.getUserName());
		bookingEntity.setDateFrom(booking.getDateFrom());
		bookingEntity.setDateTo(booking.getDateTo());
		bookingEntity.setPeopleAmount(booking.getPeopleAmount());
		bookingEntity.setRoomType(booking.getRoomType());
		
		//-- Convertimos las personas del DTO en entidades
		List<People> peopleDTOs = booking.getPeople().stream().map(person -> {
			People personEntity = new People();
			personEntity.setName(person.getName());
			personEntity.setDni(person.getDni());
			personEntity.setLastName(person.getLastName());
			personEntity.setBirthDate(person.getBirthDate());
			personEntity.setMail(person.getMail());
			return personEntity;
		}).collect(Collectors.toList());
		
		//-- Guardamos la reserva
		bookingEntity.setPeople(peopleDTOs);
		hotelBookingRepository.save(bookingEntity);

		//-- Obtenemos el usuario y el importe total
		String userName = booking.getPeople() != null && !booking.getPeople().isEmpty() ? booking.getPeople().get(0).getMail() : booking.getUserName();
		Double amount = totalAmount(booking); 
		
		StatusCodeDTO statusCode = StatusCodeDTO.builder()
				.code(200)
				.message("La reserva se ha realizado correctamente")
				.build();
		
		//-- Devolvemos el DTO de salida
		return HotelBookingDTOOutput.builder()
				.dateFrom(booking.getDateFrom())
				.dateTo(booking.getDateTo())
				.destination(booking.getDestination())
				.hotelCode(null)
				.peopleAmount(booking.getPeopleAmount())
				.roomType(booking.getRoomType())
				.people(booking.getPeople())
				.totalPrice(amount)
				.userName(userName)
				.statusCode(statusCode)
				.build();
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

	private Double totalAmount(HotelBookingDTOInput booking) {
		long nights = ChronoUnit.DAYS.between(booking.getDateFrom().toInstant(), booking.getDateTo().toInstant()) / (24 * 60 * 60 * 1000);
		if (nights == 0) nights = 1;
		int people = booking.getPeopleAmount();
		String roomType = booking.getRoomType();
		// Precios por tipo de habitacion
		int pricePerNight = 0;
		switch (roomType.toLowerCase()) {
		case "single": pricePerNight = 50000; break;
		case "double": pricePerNight = 80000; break;
		case "suite": pricePerNight = 100000; break;
		default: pricePerNight = 85000; break;
		}
		Double total = Double.valueOf(nights * people * pricePerNight);
		return total;
	}
}