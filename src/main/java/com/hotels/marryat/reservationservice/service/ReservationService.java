package com.hotels.marryat.reservationservice.service;

import com.hotels.marryat.reservationservice.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Long reservationId);

    List<Reservation> getReservationsByDateRange(LocalDate fromDate, LocalDate toDate);

}
