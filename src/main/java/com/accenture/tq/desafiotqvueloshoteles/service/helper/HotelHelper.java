package com.accenture.tq.desafiotqvueloshoteles.service.helper;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.exceptions.HotelNotFoundException;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import org.modelmapper.ModelMapper;
import java.util.Date;
import java.util.Optional;

public class HotelHelper {
  /**
   * Determina si el hotel pasado por parametro tiene disponible alguna habitacion para su reserva.
   * Para ello recupera todas las reservas del hotel y filtra las que se encuentren dentro
   * del rango de fechas solicitado, y luego compara esa cantidad con la cantidad de cuartos
   * del hotel.
   * @param optionalHotel
   * @param dateFrom
   * @param dateTo
   * @return si el hotel esta disponible o no
   */
  public boolean isAvailableBetween(Optional<Hotel> optionalHotel, Date dateFrom, Date dateTo) {
    if (optionalHotel.isPresent()) {
      Hotel hotel = optionalHotel.get();
      return !hotel.getIsReserved() && hotel.getAvailableFrom().before(dateFrom) && hotel.getAvailableTo().after(dateTo);
    } else {
      throw new HotelNotFoundException("El hotel no existe en el sistema.");
    }
  }

  /**
   * Genera un DTO de output a partir de la entidad Hotel pasada por parametro.
   * @param hotel
   * @return
   */
  public HotelDTOOutput convertToDTO(Hotel hotel) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(hotel, HotelDTOOutput.class);
  }
}
