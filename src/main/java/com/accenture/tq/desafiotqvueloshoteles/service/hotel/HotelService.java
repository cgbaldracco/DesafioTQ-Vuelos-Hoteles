package com.accenture.tq.desafiotqvueloshoteles.service.hotel;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelRepository;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class HotelService implements IHotelService {
  @Autowired
  private HotelRepository hotelRepository;

  @Autowired
  private HotelReservationRepository hotelReservationRepository;

  @Override
  public List<HotelDTOOutput> getHotels() {
    return hotelRepository.findAll().stream().map(this::convertToDTO).toList();
  }

  @Override
  public List<HotelDTOOutput> getAvailableHotels(Date dateFrom, Date dateTo, String city) {
    List<Hotel> cityHotels = hotelRepository.findAll().stream()
        .filter(hotel -> hotel.getCity().equalsIgnoreCase(city))
        .toList();

    cityHotels = cityHotels.stream().filter(hotel -> isAvailableBetween(hotel, dateFrom, dateTo)).toList();
    return cityHotels.stream().map(this::convertToDTO).toList();
  }

  private boolean isAvailableBetween(Hotel hotel, Date dateFrom, Date dateTo) {
    return hotelReservationRepository.findByHotel(hotel).stream()
        .filter(reservation ->
            (dateFrom.before(reservation.getDateTo()) && dateTo.after(reservation.getDateFrom()))
        ).toList().size() > hotel.getRooms().size();
  }

  private HotelDTOOutput convertToDTO(Hotel hotel) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.typeMap(Hotel.class, HotelDTOOutput.class).addMappings(mapper -> {
      mapper.map(Hotel::getCity, HotelDTOOutput::setCity);
      mapper.map(Hotel::getCountry, HotelDTOOutput::setCountry);
      mapper.map(Hotel::getStreet, HotelDTOOutput::setStreet);
      mapper.map(Hotel::getZipCode, HotelDTOOutput::setZipCode);
    });

    return modelMapper.map(hotel, HotelDTOOutput.class);
  }
}
