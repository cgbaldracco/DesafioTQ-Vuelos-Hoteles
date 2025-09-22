package com.accenture.tq.desafiotqvueloshoteles.service.hotels;

import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOInput;
import com.accenture.tq.desafiotqvueloshoteles.dto.booking.HotelBookingDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.booking.HotelBooking;
import com.accenture.tq.desafiotqvueloshoteles.repository.HotelBookingRepository;
import com.accenture.tq.desafiotqvueloshoteles.service.booking.BookingService;
import com.accenture.tq.desafiotqvueloshoteles.service.helper.HotelBookingHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
	
    @Mock
    private HotelBookingRepository hotelBookingRepository;
    @Mock
    private HotelBookingHelper hotelBookingHelper;


    @InjectMocks
    private BookingService bookingService;

    private HotelBookingDTOInput bookingDTOInput;
    private HotelBookingDTOOutput bookingDTOOutput;
    private HotelBooking bookingEntity;

    @BeforeEach
    void setUp() {
        Calendar calendar = Calendar.getInstance();
        Date desdeDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date hastaDate = calendar.getTime();
        bookingDTOInput = new HotelBookingDTOInput();
        bookingDTOInput.setDateFrom(desdeDate);
        bookingDTOInput.setDateTo(hastaDate);
        bookingDTOInput.setUserName("Carlos Perez");
        bookingDTOInput.setRoomType("Doble");

        bookingDTOOutput = new HotelBookingDTOOutput();
        bookingDTOOutput.setDestination("Buenos Aires");
        bookingDTOOutput.setTotalPrice(1325);
    }


    @Test
    void testOk() {
        when(hotelBookingHelper.createBookingEntity(bookingDTOInput)).thenReturn(bookingEntity);
        when(hotelBookingHelper.createBookingOutputDTO(bookingDTOInput)).thenReturn(bookingDTOOutput);
        when(hotelBookingRepository.save(bookingEntity)).thenReturn(bookingEntity);
        HotelBookingDTOOutput outputBookingDto= bookingService.createBooking(bookingDTOInput);
        assertEquals(1325, outputBookingDto.getTotalPrice());
    }

}