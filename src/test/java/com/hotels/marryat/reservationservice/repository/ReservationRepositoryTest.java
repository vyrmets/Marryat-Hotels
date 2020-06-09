package com.hotels.marryat.reservationservice.repository;

import com.hotels.marryat.reservationservice.entity.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void testFindReservationsByDateRangeShouldReturnOneResultAndBill() {
        LocalDate lowerLimit = LocalDate.of(2020, 6, 5);
        LocalDate upperLimit = LocalDate.of(2020, 6, 5);

        List<Reservation> reservations
                = (List<Reservation>) reservationRepository.findReservationsByDateRange(lowerLimit, upperLimit);

        assertThat(reservations, hasSize(1));
        assertThat(reservations.get(0).getFirstName(), is("Bill"));
    }

    @Test
    public void testFindReservationsByDateRangeShouldReturnTwoResultsBillAndTom() {
        LocalDate lowerLimit = LocalDate.of(2020, 6, 7);
        LocalDate upperLimit = LocalDate.of(2020, 6, 10);

        List<Reservation> reservations
                = (List<Reservation>) reservationRepository.findReservationsByDateRange(lowerLimit, upperLimit);

        assertThat(reservations, hasSize(2));
        assertThat(reservations.get(0).getFirstName(), is("Bill"));
        assertThat(reservations.get(1).getFirstName(), is("Tom"));
    }
}
