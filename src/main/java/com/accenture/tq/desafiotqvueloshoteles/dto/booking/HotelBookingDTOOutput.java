package com.accenture.tq.desafiotqvueloshoteles.dto.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.general.PeopleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class HotelBookingDTOOutput {
  private Date dateFrom;
  private Date dateTo;
  private String destination;
  private String hotelCode;
  private int peopleAmount;
  private String roomType;
  private List<PeopleDTO> people;
}
