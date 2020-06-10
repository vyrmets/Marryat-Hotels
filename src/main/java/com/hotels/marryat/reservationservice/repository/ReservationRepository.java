package com.hotels.marryat.reservationservice.repository;

import com.hotels.marryat.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.startDate <= :upperLimit AND r.endDate >= :lowerLimit")
    List<Reservation> findReservationsByDateRange(LocalDate lowerLimit, LocalDate upperLimit);
}