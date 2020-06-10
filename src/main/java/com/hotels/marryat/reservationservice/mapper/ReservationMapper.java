package com.hotels.marryat.reservationservice.mapper;

import com.hotels.marryat.reservationservice.dto.ReservationDto;
import com.hotels.marryat.reservationservice.entity.Reservation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class ReservationMapper {

    public List<ReservationDto> reservationsToDtos(List<Reservation> reservations) {
        return reservations.stream().map(this::reservationToReservationDto).collect(toList());
    }

    public ReservationDto reservationToReservationDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setFirstName(reservation.getFirstName());
        reservationDto.setLastName(reservation.getLastName());
        reservationDto.setRoomNumber(reservation.getRoomNumber());
        reservationDto.setStartDate(reservation.getStartDate());
        reservationDto.setEndDate(reservation.getEndDate());
        return reservationDto;
    }

    public List<Reservation> reservationDtosToReservation(List<ReservationDto> reservationDtos) {
        return reservationDtos.stream().map(this::reservationDtoToReservation).collect(Collectors.toList());
    }

    public Reservation reservationDtoToReservation(ReservationDto reservationDto) {
            Reservation reservation = new Reservation();
            reservation.setId(reservationDto.getId());
            reservation.setFirstName(reservationDto.getFirstName());
            reservation.setLastName(reservationDto.getLastName());
            reservation.setRoomNumber(reservationDto.getRoomNumber());
            reservation.setStartDate(reservationDto.getStartDate());
            reservation.setEndDate(reservationDto.getEndDate());
            return reservation;
    }
}
