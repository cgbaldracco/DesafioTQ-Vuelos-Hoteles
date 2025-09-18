package com.accenture.tq.desafiotqvueloshoteles.service.flight;

import com.accenture.tq.desafiotqvueloshoteles.dto.flight.FlightDTOOutput;
import com.accenture.tq.desafiotqvueloshoteles.model.entities.flight.Flight;
import com.accenture.tq.desafiotqvueloshoteles.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {
	
    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight();
        flight.setFlightNumber("FL123");
        flight.setOrigin("Buenos Aires");
        flight.setDestination("Madrid");
        flight.setSeatType("Economy");
        flight.setAmount(1000.0);
        flight.setDateFrom(LocalDate.of(2025, 9, 20));
        flight.setDateTo(LocalDate.of(2025, 9, 30));
    }

    @Test
    void testNoHayVuelos() {
        when(flightRepository.existsByOrigin("Buenos Aires")).thenReturn(true);
        when(flightRepository.existsByDestination("Madrid")).thenReturn(true);
        when(flightRepository.findAvailableFlights(any(), any(), eq("Buenos Aires"), eq("Madrid")))
                .thenReturn(Collections.emptyList());

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            flightService.getAvailableFlights("20/09/2025", "30/09/2025", "Buenos Aires", "Madrid")
        );
        assertTrue(ex.getMessage().contains("No hay vuelos disponibles"));
    }
    
    @Test
    void testOk() {
        when(flightRepository.existsByOrigin("Buenos Aires")).thenReturn(true);
        when(flightRepository.existsByDestination("Madrid")).thenReturn(true);
        when(flightRepository.findAvailableFlights(any(), any(), eq("Buenos Aires"), eq("Madrid")))
                .thenReturn(Arrays.asList(flight));

        List<FlightDTOOutput> result = flightService.getAvailableFlights("20/09/2025", "30/09/2025", "Buenos Aires", "Madrid");
        assertEquals(1, result.size());
        assertEquals("FL123", result.get(0).getFlightNumber());
    }

    @Test
    void testFechaInvalida() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                flightService.getAvailableFlights("2025-09-20", "30/09/2025", "Buenos Aires", "Madrid")
        );
        assertTrue(ex.getMessage().contains("Formato de fecha"));
    }

    @Test
    void testFechaMenor() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                flightService.getAvailableFlights("30/09/2025", "20/09/2025", "Buenos Aires", "Madrid")
        );
        assertTrue(ex.getMessage().contains("ida debe ser menor"));
    }

    @Test
    void testOrigenInexistente() {
        when(flightRepository.existsByOrigin("Cordoba")).thenReturn(false);
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                flightService.getAvailableFlights("20/09/2025", "30/09/2025", "Cordoba", "Madrid")
        );
        assertTrue(ex.getMessage().contains("origen elegido no existe"));
    }

    @Test
    void testDestinoInexistente() {
        when(flightRepository.existsByOrigin("Buenos Aires")).thenReturn(true);
        when(flightRepository.existsByDestination("Roma")).thenReturn(false);
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                flightService.getAvailableFlights("20/09/2025", "30/09/2025", "Buenos Aires", "Roma")
        );
        assertTrue(ex.getMessage().contains("destino elegido no existe"));
    }
    
    @Test
    void testDevuelveVuelos() {
    	when(flightRepository.findAll()).thenReturn(Arrays.asList(flight));

		List<FlightDTOOutput> result = flightService.getAllFlights();
		assertEquals(1, result.size());
		assertEquals("FL123", result.get(0).getFlightNumber());
    }
    
    @Test
    void testNoDevuelveVuelos() {
    	when(flightRepository.findAll()).thenReturn(Collections.emptyList());

		Exception ex = assertThrows(IllegalArgumentException.class, () ->
			flightService.getAllFlights()
		);
		assertTrue(ex.getMessage().contains("No hay vuelos disponibles"));
    }
  
}