package com.hotels.marryat.reservationservice.service;

import com.hotels.marryat.reservationservice.dto.DateRange;
import com.hotels.marryat.reservationservice.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();

    Reservation createReservation(Reservation reservation);

    void deleteReservation(Long reservationId);

    List<Reservation> getAllReservations(DateRange dateRange);

}
