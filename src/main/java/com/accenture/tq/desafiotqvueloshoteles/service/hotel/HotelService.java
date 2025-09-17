package com.accenture.tq.desafiotqvueloshoteles.service.hotel;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.exceptions.HotelNotFoundException;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelRepository;
import com.accenture.tq.desafiotqvueloshoteles.service.helper.HotelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.FutureOrPresent;
import java.util.Date;
import java.util.List;

@Service
public class HotelService implements IHotelService {
  @Autowired
  private HotelRepository hotelRepository;

  private final HotelHelper hotelHelper = new HotelHelper();

  @Override
  public List<HotelDTOOutput> getHotels() {
    return hotelRepository.findAll().stream().map(hotelHelper::convertToDTO).toList();
  }

  /**
   * Recupera del repositorio los hoteles de la ciudad pasada por parametro. Luego
   * determina con cuales quedarse utilizando el metodo isAvailableBetween.
   * Si alguno de los parametros es nulo, ignora los filtros y devuelve todos los hoteles.
   * @param dateFrom
   * @param dateTo
   * @param city
   * @return Lista de hoteles de la ciudad disponibles dentro de las fechas.
   */
  @Override
  public List<HotelDTOOutput> getAvailableHotels(@FutureOrPresent Date dateFrom, @FutureOrPresent Date dateTo,
                                                 String city) {
    if(dateFrom == null || dateTo == null || city == null) {
      return getHotels();
    }
    if(dateFrom.after(dateTo)) {
      throw new IllegalArgumentException("La fecha desde debe ser menor a la fecha hasta.");
    }
    if(dateTo.before(dateFrom)) {
      throw new IllegalArgumentException("La fecha hasta debe ser mayor a la fecha desde.");
    }

    List<Hotel> cityHotels = hotelRepository.findAll().stream()
        .filter(hotel -> hotel.getCity().equalsIgnoreCase(city))
        .toList();

    if(cityHotels.isEmpty()) {
      throw new HotelNotFoundException("El destino elegido no existe.");
    }

    cityHotels = cityHotels.stream().filter(hotel -> hotelHelper
        .isAvailableBetween(hotelRepository.findById(hotel.getId()), dateFrom, dateTo)).toList();
    return cityHotels.stream().map(hotelHelper::convertToDTO).toList();
  }
}
