package com.hotels.marryat.reservationservice.controller;

import com.hotels.marryat.reservationservice.dto.ReservationDto;
import com.hotels.marryat.reservationservice.exception.BadRequestException;
import com.hotels.marryat.reservationservice.mapper.ReservationMapper;
import com.hotels.marryat.reservationservice.service.ReservationService;
import com.hotels.marryat.reservationservice.service.ReservationServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationServiceImpl reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping
    @ResponseBody
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.reservationsToDtos(reservationService.getAllReservations());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservation(@RequestBody ReservationDto reservation) {
        if (reservation.getId() != null) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "You cannot create reservation with specific ID");
        }
        reservationService.createReservation(reservationMapper.reservationDtoToReservation(reservation));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReservation(@PathVariable("id") Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateReservation(@RequestBody ReservationDto reservation) {
        reservationService.updateReservation(reservationMapper.reservationDtoToReservation(reservation));
    }

    @GetMapping("/dates")
    @ResponseBody
    public List<ReservationDto> getReservationsByDateRange(
            @RequestParam(value = "fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
            @RequestParam(value = "toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
        return reservationMapper.reservationsToDtos(reservationService.getReservationsByDateRange(fromDate, toDate));
    }

}
