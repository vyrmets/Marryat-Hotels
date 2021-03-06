package com.hotels.marryat.reservationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotels.marryat.reservationservice.dto.ReservationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.time.LocalDate.of;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationController reservationController;

    @Test
    public void testGetReservationsWithoutParams() throws Exception {
        ReservationDto reservation = new ReservationDto();
        reservation.setFirstName("Bill");

        when(reservationController.getAllReservations(null, null)).thenReturn(singletonList(reservation));

        mockMvc.perform(get("/reservation"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is("Bill")));
    }

    @Test
    public void testGetReservationsWithRange() throws Exception {
        ReservationDto reservation = new ReservationDto();
        reservation.setFirstName("Bill");

        when(reservationController.getAllReservations(of(2020, 1, 1), of(2020, 1, 1)))
                .thenReturn(singletonList(reservation));

        mockMvc.perform(get("/reservation")
                .param("fromDate", "2020-01-01")
                .param("toDate", "2020-01-02"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteReservation() throws Exception {
        mockMvc.perform(delete("/reservation/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }

    @Test
    public void testCreateReservation() throws Exception {
        ReservationDto reservation = new ReservationDto();
        reservation.setFirstName("Bill");

        mockMvc.perform(post("/reservation")
                .content(asJsonString(reservation))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateReservation() throws Exception {
        ReservationDto reservation = new ReservationDto();
        reservation.setFirstName("Bill");

        mockMvc.perform(put("/reservation")
                .content(asJsonString(reservation))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isAccepted());
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
