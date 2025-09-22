package com.accenture.tq.desafiotqvueloshoteles.utils;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotelCustomFactory {

  // Consistent default values
  public static final Long DEFAULT_HOTEL_ID = 1L;
  public static final String DEFAULT_HOTEL_CODE = "HTL001";
  public static final String DEFAULT_HOTEL_NAME = "Hotel Central";
  public static final String DEFAULT_CITY = "Buenos Aires";
  public static final String DEFAULT_ROOM_TYPE = "Single";
  public static final BigInteger DEFAULT_AMOUNT_PER_NIGHT = BigInteger.valueOf(1000);
  public static final Date DEFAULT_AVAILABLE_FROM = new Date(2024-1900, Calendar.JULY, 1); // July 1, 2024
  public static final Date DEFAULT_AVAILABLE_TO = new Date(2024-1900, Calendar.JULY, 10); // July 10, 2024
  public static final Boolean DEFAULT_IS_RESERVED = false;

  // Specific method for default hotel
  public static Hotel createDefaultHotel() {
    return Hotel.builder()
        .id(DEFAULT_HOTEL_ID)
        .hotelCode(DEFAULT_HOTEL_CODE)
        .hotelName(DEFAULT_HOTEL_NAME)
        .city(DEFAULT_CITY)
        .roomType(DEFAULT_ROOM_TYPE)
        .amountPerNight(DEFAULT_AMOUNT_PER_NIGHT)
        .availableFrom(DEFAULT_AVAILABLE_FROM)
        .availableTo(DEFAULT_AVAILABLE_TO)
        .isReserved(DEFAULT_IS_RESERVED)
        .build();
  }

  // Generic method for custom hotel
  public static Hotel createHotelWithCustomValues(Long id, String code, String name, String city, String roomType,
                                                  BigInteger amountPerNight, Date availableFrom, Date availableTo, Boolean isReserved) {
    return Hotel.builder()
        .id(id)
        .hotelCode(code)
        .hotelName(name)
        .city(city)
        .roomType(roomType)
        .amountPerNight(amountPerNight)
        .availableFrom(availableFrom)
        .availableTo(availableTo)
        .isReserved(isReserved)
        .build();
  }

  // Descriptive method for a reserved hotel
  public static Hotel createReservedHotel() {
    Hotel hotel = createDefaultHotel();
    hotel.setIsReserved(true);
    return hotel;
  }

  // List of hotels for test scenarios
  public static List<Hotel> createHotelListWithTwoHotels() {
    return List.of(
        createDefaultHotel(),
        createHotelWithCustomValues(
            2L, "HTL002", "Hotel Sur", "Cordoba", "Double",
            BigInteger.valueOf(800),
            new Date(2024-1900, Calendar.JULY, 5),
            new Date(2024-1900, Calendar.JULY, 15),
            false
        )
    );
  }

  // DTO output methods
  public static HotelDTOOutput createDefaultHotelDTOOutput() {
    HotelDTOOutput dto = new HotelDTOOutput();
    dto.setId(DEFAULT_HOTEL_ID);
    dto.setHotelCode(DEFAULT_HOTEL_CODE);
    dto.setHotelName(DEFAULT_HOTEL_NAME);
    dto.setCity(DEFAULT_CITY);
    dto.setRoomType(DEFAULT_ROOM_TYPE);
    dto.setAmountPerNight(DEFAULT_AMOUNT_PER_NIGHT);
    dto.setAvailableFrom(DEFAULT_AVAILABLE_FROM);
    dto.setAvailableTo(DEFAULT_AVAILABLE_TO);
    dto.setReserved(DEFAULT_IS_RESERVED);
    return dto;
  }

  public static HotelDTOOutput createHotelDTOOutputWithCustomValues(Long id, String hotelCode, String hotelName, String city,
                                                                    String roomType, BigInteger amountPerNight, Date availableFrom,
                                                                    Date availableTo, boolean isReserved) {
    HotelDTOOutput dto = new HotelDTOOutput();
    dto.setId(id);
    dto.setHotelCode(hotelCode);
    dto.setHotelName(hotelName);
    dto.setCity(city);
    dto.setRoomType(roomType);
    dto.setAmountPerNight(amountPerNight);
    dto.setAvailableFrom(availableFrom);
    dto.setAvailableTo(availableTo);
    dto.setReserved(isReserved);
    return dto;
  }

  public static List<HotelDTOOutput> createHotelDTOOutputListWithTwoHotels() {
    return List.of(
        createDefaultHotelDTOOutput(),
        createHotelDTOOutputWithCustomValues(
            2L, "HTL002", "Hotel Sur", "Cordoba", "Double",
            BigInteger.valueOf(800),
            new Date(2024-1900, Calendar.JULY, 5),
            new Date(2024-1900, Calendar.JULY, 15),
            false
        )
    );
  }
}


