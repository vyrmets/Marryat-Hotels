package com.hotels.marryat.reservationservice.repository;

import com.hotels.marryat.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r " +
            "WHERE (r.startDate BETWEEN :lowerLimit AND :upperLimit) " +
            "OR (r.endDate BETWEEN :lowerLimit AND :upperLimit)" +
            "OR (r.startDate < :lowerLimit AND r.endDate > :upperLimit)")
    Iterable<Reservation> findReservationsByDateRange(LocalDate lowerLimit, LocalDate upperLimit);
}
