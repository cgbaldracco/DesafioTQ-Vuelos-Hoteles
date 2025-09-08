package com.accenture.tq.desafiotqvueloshoteles.dto.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PaymentMethodDTO {
  private String type;
  private String number;
  private int dues;
}
