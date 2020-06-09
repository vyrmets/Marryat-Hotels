package com.hotels.marryat.reservationservice.mapper;

import com.hotels.marryat.reservationservice.dto.ReservationDto;
import com.hotels.marryat.reservationservice.entity.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ReservationMapperTest {

    private final ReservationMapper reservationMapper = new ReservationMapper();

    @Test
    public void testReservationsToDtos() {
        List<Reservation> reservations = Collections.singletonList(buildReservation());

        List<ReservationDto> reservationDtos = reservationMapper.reservationsToDtos(reservations);

        assertEquals(reservations.get(0).getId(), reservationDtos.get(0).getId());
        assertEquals(reservations.get(0).getFirstName(), reservationDtos.get(0).getFirstName());
        assertEquals(reservations.get(0).getLastName(), reservationDtos.get(0).getLastName());
        assertEquals(reservations.get(0).getRoomNumber(), reservationDtos.get(0).getRoomNumber());
        assertEquals(reservations.get(0).getStartDate(), reservationDtos.get(0).getStartDate());
        assertEquals(reservations.get(0).getEndDate(), reservationDtos.get(0).getEndDate());
    }

    @Test
    public void testReservationToDto() {
        Reservation reservation = buildReservation();

        ReservationDto reservationDto = reservationMapper.reservationToReservationDto(reservation);

        assertEquals(reservation.getId(), reservationDto.getId());
        assertEquals(reservation.getFirstName(), reservationDto.getFirstName());
        assertEquals(reservation.getLastName(), reservationDto.getLastName());
        assertEquals(reservation.getRoomNumber(), reservationDto.getRoomNumber());
        assertEquals(reservation.getStartDate(), reservationDto.getStartDate());
        assertEquals(reservation.getEndDate(), reservationDto.getEndDate());
    }

    @Test
    public void testDtoToReservation() {
        ReservationDto reservationDto = buildReservationDto();

        Reservation reservation = reservationMapper.reservationDtoToReservation(reservationDto);

        assertEquals(reservationDto.getId(), reservation.getId());
        assertEquals(reservationDto.getFirstName(), reservation.getFirstName());
        assertEquals(reservationDto.getLastName(), reservation.getLastName());
        assertEquals(reservationDto.getRoomNumber(), reservation.getRoomNumber());
        assertEquals(reservationDto.getStartDate(), reservation.getStartDate());
        assertEquals(reservationDto.getEndDate(), reservation.getEndDate());
    }

    @Test
    public void testDtosToReservations() {
        List<ReservationDto> reservationDtos = Collections.singletonList(buildReservationDto());

        List<Reservation> reservations = reservationMapper.reservationDtosToReservation(reservationDtos);

        assertEquals(reservationDtos.get(0).getId(), reservations.get(0).getId());
        assertEquals(reservationDtos.get(0).getFirstName(), reservations.get(0).getFirstName());
        assertEquals(reservationDtos.get(0).getLastName(), reservations.get(0).getLastName());
        assertEquals(reservationDtos.get(0).getRoomNumber(), reservations.get(0).getRoomNumber());
        assertEquals(reservationDtos.get(0).getStartDate(), reservations.get(0).getStartDate());
        assertEquals(reservationDtos.get(0).getEndDate(), reservations.get(0).getEndDate());
    }

    private Reservation buildReservation() {
        final Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setFirstName("Bill");
        reservation.setLastName("Clinton");
        reservation.setRoomNumber((short) 1);
        reservation.setStartDate(LocalDate.of(2020, 1, 30));
        reservation.setStartDate(LocalDate.of(2020, 1, 31));
        return reservation;
    }

    private ReservationDto buildReservationDto() {
        final ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(1L);
        reservationDto.setFirstName("Bill");
        reservationDto.setLastName("Clinton");
        reservationDto.setRoomNumber((short) 1);
        reservationDto.setStartDate(LocalDate.of(2020, 1, 30));
        reservationDto.setStartDate(LocalDate.of(2020, 1, 31));
        return reservationDto;
    }
}
