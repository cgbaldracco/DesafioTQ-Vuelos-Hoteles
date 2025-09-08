package com.accenture.tq.desafiotqvueloshoteles.service.hotel;

import com.accenture.tq.desafiotqvueloshoteles.dto.hotel.HotelDTOOutput;
import java.util.Date;
import java.util.List;

public interface IHotelService {
  List<HotelDTOOutput> getHotels();
  List<HotelDTOOutput> getAvailableHotels(Date dateFrom, Date dateTo, String city);
}
