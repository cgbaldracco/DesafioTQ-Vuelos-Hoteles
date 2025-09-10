package com.accenture.tq.desafiotqvueloshoteles.model.entities.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import jakarta.persistence.Embeddable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class People {
  private String dni;
  private String name;
  private String lastName;
  private Date birthDate;
  private String mail;
}
