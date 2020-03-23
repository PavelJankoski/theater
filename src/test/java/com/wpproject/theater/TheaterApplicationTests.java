package com.wpproject.theater;

import com.wpproject.theater.repositories.SeatReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TheaterApplicationTests {

    @Autowired
    private SeatReservationRepository seatReservationRepository;

    @Test
    void contextLoads() {
        assertEquals(15, seatReservationRepository.showReservations(2).size());

    }

}
