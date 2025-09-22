package com.accenture.tq.desafiotqvueloshoteles.service.hotels;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.hotel.Hotel;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelRepository;
import com.accenture.tq.desafiotqvueloshoteles.service.hotel.HotelService;
import com.accenture.tq.desafiotqvueloshoteles.utils.HotelCustomFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelServiceTest {

  @Mock
  private HotelRepository hotelRepository;

  @InjectMocks
  private HotelService hotelService;

  private List<Hotel> hotelList;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    hotelList = HotelCustomFactory.createHotelListWithTwoHotels();
  }

  @Test
  void getHotels_returnsAllHotelsAsDTOs() {
    when(hotelRepository.findAll()).thenReturn(hotelList);
    List<HotelDTOOutput> result = hotelService.getHotels();
    assertEquals(2, result.size());
    assertEquals(HotelCustomFactory.DEFAULT_HOTEL_NAME, result.get(0).getHotelName());
    assertEquals("Hotel Sur", result.get(1).getHotelName());
  }

  @Test
  void getAvailableHotels_returnsFilteredHotels() {
    when(hotelRepository.findAll()).thenReturn(hotelList);
    when(hotelRepository.findById(HotelCustomFactory.DEFAULT_HOTEL_ID))
        .thenReturn(Optional.of(hotelList.get(0)));
    Date from = new Date(2024-1900, Calendar.JULY, 2);
    Date to = new Date(2024-1900, Calendar.JULY, 9);
    List<HotelDTOOutput> result = hotelService.getAvailableHotels(from, to, HotelCustomFactory.DEFAULT_CITY);
    assertEquals(1, result.size());
    assertEquals(HotelCustomFactory.DEFAULT_HOTEL_NAME, result.get(0).getHotelName());
  }

  @Test
  void getAvailableHotels_nullParams_returnsAllHotels() {
    when(hotelRepository.findAll()).thenReturn(hotelList);
    List<HotelDTOOutput> result = hotelService.getAvailableHotels(null, null, null);
    assertEquals(2, result.size());
  }

  @Test
  void getAvailableHotels_invalidDates_throwsException() {
    Date from = new Date(2024-1900, Calendar.JULY, 10);
    Date to = new Date(2024-1900, Calendar.JULY, 1);
    assertThrows(IllegalArgumentException.class, () ->
        hotelService.getAvailableHotels(from, to, HotelCustomFactory.DEFAULT_CITY));
  }

  @Test
  void getAvailableHotels_cityNotFound_throwsException() {
    when(hotelRepository.findAll()).thenReturn(hotelList);
    assertThrows(com.accenture.tq.desafiotqvueloshoteles.exceptions.HotelNotFoundException.class, () ->
        hotelService.getAvailableHotels(new Date(), new Date(), "Rosario"));
  }
}
