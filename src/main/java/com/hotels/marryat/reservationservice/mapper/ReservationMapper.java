package com.hotels.marryat.reservationservice.mapper;

import com.hotels.marryat.reservationservice.dto.ReservationDto;
import com.hotels.marryat.reservationservice.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ReservationMapper {
    public List<ReservationDto> reservationsToDtos(List<Reservation> reservations) {
        return reservations.stream().filter(Objects::nonNull).map(this::reservationToReservationDto).collect(toList());
    }

    public ReservationDto reservationToReservationDto(Reservation reservation) {
        return new ReservationDto(reservation);
    }

    public List<Reservation> reservationDtosToReservation(List<ReservationDto> reservationDtos) {
        return reservationDtos.stream().filter(Objects::nonNull).map(this::reservationDtoToReservation).collect(Collectors.toList());
    }

    public Reservation reservationDtoToReservation(ReservationDto reservationDto) {
        if (reservationDto == null) {
            return null;
        } else {
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
}
