package com.hotels.marryat.reservationservice.service;

import com.hotels.marryat.reservationservice.entity.Reservation;
import com.hotels.marryat.reservationservice.repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Test
    public void testGetAllReservations() {
        when(reservationRepository.findAll()).thenReturn(singletonList(buildReservation()));

        List<Reservation> allReservations = reservationService.getAllReservations();

        verify(reservationRepository).findAll();
        assertThat(allReservations, hasSize(1));
        assertThat(allReservations.get(0), is(buildReservation()));
    }

    @Test
    public void testCreateReservation() {
        when(reservationRepository.save(buildReservation())).thenReturn(buildReservation());

        Reservation reservation = reservationService.createReservation(buildReservation());

        verify(reservationRepository).save(buildReservation());
        assertThat(reservation, is(buildReservation()));
    }

    @Test
    public void testDeleteReservation() {
        reservationService.deleteReservation(1L);

        verify(reservationRepository).deleteById(1L);
    }

    @Test
    public void testUpdateReservation() {
        when(reservationRepository.save(buildReservation())).thenReturn(buildReservation());

        Reservation reservation = reservationService.updateReservation(buildReservation());

        verify(reservationRepository).save(buildReservation());
        assertThat(reservation, is(buildReservation()));
    }

    @Test
    public void testGetReservationsById() {
        LocalDate lowerLimit = LocalDate.of(2020, 1, 1);
        LocalDate upperLimit = LocalDate.of(2020, 1, 2);

        when(reservationRepository.findReservationsByDateRange(lowerLimit, upperLimit)).thenReturn(singletonList(buildReservation()));

        List<Reservation> reservationsByDateRange = reservationService.getReservationsByDateRange(lowerLimit, upperLimit);

        verify(reservationRepository).findReservationsByDateRange(lowerLimit, upperLimit);
        assertThat(reservationsByDateRange, hasSize(1));
        assertThat(reservationsByDateRange.get(0), is(buildReservation()));
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
}
