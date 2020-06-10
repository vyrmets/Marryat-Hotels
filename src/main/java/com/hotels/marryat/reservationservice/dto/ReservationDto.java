package com.hotels.marryat.reservationservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ReservationDto {

    private Long id;

    private String firstName;

    private String lastName;

    private short roomNumber;

    private LocalDate startDate;

    private LocalDate endDate;
}
