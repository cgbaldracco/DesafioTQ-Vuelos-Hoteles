package com.accenture.tq.desafiotqvueloshoteles.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StatusCodeDTO {
    private int code;
    private String message;

    public StatusCodeDTO() {}
}
