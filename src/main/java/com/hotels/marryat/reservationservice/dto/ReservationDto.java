package com.hotels.marryat.reservationservice.dto;

import com.hotels.marryat.reservationservice.entity.Reservation;

import java.time.LocalDate;
import java.util.Objects;

public class ReservationDto {

    private Long id;

    private String firstName;

    private String lastName;

    private short roomNumber;

    private LocalDate startDate;

    private LocalDate endDate;

    public ReservationDto() {
        //default constructor
    }

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.firstName = reservation.getFirstName();
        this.lastName = reservation.getLastName();
        this.roomNumber = reservation.getRoomNumber();
        this.startDate = reservation.getStartDate();
        this.endDate = reservation.getEndDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(short roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReservationDto that = (ReservationDto) o;
        return roomNumber == that.roomNumber &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, roomNumber, startDate, endDate);
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roomNumber=" + roomNumber +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
