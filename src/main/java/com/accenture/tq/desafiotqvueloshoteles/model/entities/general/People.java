package com.accenture.tq.desafiotqvueloshoteles.model.entities.general;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class People {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String dni;
  private String name;
  private String lastname;
  private Date birthDate;
  private String mail;
}

