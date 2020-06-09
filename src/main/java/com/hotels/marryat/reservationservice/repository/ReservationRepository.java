package com.hotels.marryat.reservationservice.repository;

import com.hotels.marryat.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.startDate = ?1 AND r.endDate = ?2")
    Iterable<Reservation> findReservationsByDateRange(Date startDate, Date endDate);
}
