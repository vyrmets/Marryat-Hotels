package com.hotels.marryat.reservationservice.dto;

import com.hotels.marryat.reservationservice.entity.Reservation;

import java.sql.Date;

public class ReservationDto {

    private Long id;

    private String firstName;

    private String lastName;

    private short roomNumber;

    private Date startDate;

    private Date endDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
