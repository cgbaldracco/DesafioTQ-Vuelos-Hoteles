package com.accenture.tq.desafiotqvueloshoteles.dto.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PeopleDTO {
  private String dni;
  private String name;
  private String lastName;
  private Date birthDate;
  private String mail;
}
