package com.accenture.tq.desafiotqvueloshoteles.service.helper;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.dto.general.StatusCodeDTO;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.booking.HotelBooking;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.general.People;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelBookingHelper {
  /**
   * Metodo que calcula el importe total de la reserva a partir del tipo de habitacion,
   * la cantidad de personas y la cantidad de noches.
   * @param booking
   * @return monto total de la reserva
   */
  private Double totalAmount(HotelBookingDTOInput booking) {
    long nights = ChronoUnit.DAYS.between(booking.getDateFrom().toInstant(), booking.getDateTo().toInstant()) / (24 * 60 * 60 * 1000);
    if (nights == 0) nights = 1;
    int people = booking.getPeopleAmount();
    String roomType = booking.getRoomType();
    // Precios por tipo de habitacion
    int pricePerNight = switch (roomType.toLowerCase()) {
      case "single" -> 50000;
      case "double" -> 80000;
      case "suite" -> 100000;
      default -> 85000;
    };
    return (Double) (double) (nights * people * pricePerNight);
  }

  /**
   * Metodo para crear un HotelBooking a partir de los datos de input del DTO recibido.
   * @param booking
   * @return entidad HotelBooking
   */
  public HotelBooking createBookingEntity(HotelBookingDTOInput booking) {
    HotelBooking bookingEntity = new HotelBooking();
    bookingEntity.setUserName(booking.getUserName());
    bookingEntity.setDateFrom(booking.getDateFrom());
    bookingEntity.setDateTo(booking.getDateTo());
    bookingEntity.setPeopleAmount(booking.getPeopleAmount());
    bookingEntity.setRoomType(booking.getRoomType());
    List<People> peopleEntities = booking.getPeople().stream().map(person -> {
      People personEntity = new People();
      personEntity.setName(person.getName());
      personEntity.setLastName(person.getLastName());
      personEntity.setDni(person.getDni());
      personEntity.setBirthDate(person.getBirthDate());
      personEntity.setMail(person.getMail());
      return personEntity;
    }).collect(Collectors.toList());
    bookingEntity.setPeople(peopleEntities);
    return bookingEntity;
  }

  /**
   * Metodo que crea el output de salida tras haber creado una reserva de hotel.
   * @param booking
   * @return Output con los datos de la reserva creada.
   */
  public HotelBookingDTOOutput createBookingOutputDTO(HotelBookingDTOInput booking) {
    //-- Obtenemos el usuario y el importe total
    String userName = booking.getUserName();
    Double amount = totalAmount(booking);

    StatusCodeDTO statusCode = StatusCodeDTO.builder()
        .code(200)
        .message("La reserva se ha realizado correctamente")
        .build();

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
}
