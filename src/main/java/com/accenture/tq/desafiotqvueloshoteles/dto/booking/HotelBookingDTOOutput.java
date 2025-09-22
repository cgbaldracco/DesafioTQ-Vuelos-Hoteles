package com.accenture.tq.desafiotqvueloshoteles.dto.booking;

import com.accenture.tq.desafiotqvueloshoteles.dto.general.PeopleDTO;
import com.accenture.tq.desafiotqvueloshoteles.dto.general.StatusCodeDTO;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelBookingDTOOutput {
 
	private Date dateFrom;
	private Date dateTo;
	private String destination;
	private String hotelCode;
	private int peopleAmount;
	private String roomType;
	private List<PeopleDTO> people;
	private double totalPrice;
	private String userName;
	private StatusCodeDTO statusCode;
}
