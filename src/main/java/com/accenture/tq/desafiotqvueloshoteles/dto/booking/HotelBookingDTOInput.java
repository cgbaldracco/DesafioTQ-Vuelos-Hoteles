package com.accenture.tq.desafiotqvueloshoteles.dto.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.general.PaymentMethodDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.general.PeopleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelBookingDTOInput {
	
  private Date dateFrom;
  private Date dateTo;
  private String userName;
  private String destination;
  private int peopleAmount;
  private String roomType;
  private List<PeopleDTO> people;
  private PaymentMethodDTO paymentMethod;
}