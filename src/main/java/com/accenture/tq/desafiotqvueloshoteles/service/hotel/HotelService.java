package com.accenture.tq.desafiotqvueloshoteles.service.hotel;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import com.accenture.tq.desafiotqvueloshoteles.exceptions.HotelNotFoundException;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements IHotelService {
  @Autowired
  private HotelRepository hotelRepository;

  @Override
  public List<HotelDTOOutput> getHotels() {
    return hotelRepository.findAll().stream().map(this::convertToDTO).toList();
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
  public List<HotelDTOOutput> getAvailableHotels(Date dateFrom, Date dateTo, String city) {
    if(dateFrom == null || dateTo == null || city == null) {
      return getHotels();
    }

    List<Hotel> cityHotels = hotelRepository.findAll().stream()
        .filter(hotel -> hotel.getCity().equalsIgnoreCase(city))
        .toList();

    cityHotels = cityHotels.stream().filter(hotel -> isAvailableBetween(hotel.getId(), dateFrom, dateTo)).toList();
    return cityHotels.stream().map(this::convertToDTO).toList();
  }

  /**
   * Determina si el hotel pasado por parametro tiene disponible alguna habitacion para su reserva.
   * Para ello recupera todas las reservas del hotel y filtra las que se encuentren dentro
   * del rango de fechas solicitado, y luego compara esa cantidad con la cantidad de cuartos
   * del hotel.
   * @param hotelId
   * @param dateFrom
   * @param dateTo
   * @return si el hotel esta disponible o no
   */
  private boolean isAvailableBetween(Long hotelId, Date dateFrom, Date dateTo) {
    Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
    if (optionalHotel.isPresent()) {
      Hotel hotel = optionalHotel.get();
      return !hotel.getIsReserved() && hotel.getAvailableFrom().before(dateFrom) && hotel.getAvailableTo().after(dateTo);
    } else {
      throw new HotelNotFoundException("Hotel not found in the database.");
    }
  }

  /**
   * Genera un DTO de output a partir de la entidad Hotel pasada por parametro.
   * @param hotel
   * @return
   */
  private HotelDTOOutput convertToDTO(Hotel hotel) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(hotel, HotelDTOOutput.class);
  }
}
