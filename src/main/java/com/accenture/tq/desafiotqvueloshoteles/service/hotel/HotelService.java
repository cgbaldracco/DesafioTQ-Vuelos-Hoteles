package com.accenture.tq.desafiotqvueloshoteles.service.hotel;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import com.accenture.tq.desafiotqvueloshoteles.exceptions.HotelNotFoundException;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelRepository;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelBookingRepository;
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

  @Autowired
  private HotelBookingRepository hotelBookingRepository;

  @Override
  public List<HotelDTOOutput> getHotels() {
    return hotelRepository.findAll().stream().map(this::convertToDTO).toList();
  }

  @Override
  public List<HotelDTOOutput> getAvailableHotels(Date dateFrom, Date dateTo, String city) {
    List<Hotel> cityHotels = hotelRepository.findAll().stream()
        .filter(hotel -> hotel.getCity().equalsIgnoreCase(city))
        .toList();

    cityHotels = cityHotels.stream().filter(hotel -> isAvailableBetween(hotel.getId(), dateFrom, dateTo)).toList();
    return cityHotels.stream().map(this::convertToDTO).toList();
  }

  private boolean isAvailableBetween(Long hotelId, Date dateFrom, Date dateTo) {
    int overlappingReservations = hotelBookingRepository.findByHotelId(hotelId).stream()
        .filter(reservation ->
            (dateFrom.before(reservation.getDateTo()) && dateTo.after(reservation.getDateFrom()))
        ).toList().size();

    Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
    if (optionalHotel.isPresent()) {
      Hotel hotel = optionalHotel.get();
      return overlappingReservations < hotel.getRooms().size();
    } else {
      throw new HotelNotFoundException("Hotel not found in the database.");
    }
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
