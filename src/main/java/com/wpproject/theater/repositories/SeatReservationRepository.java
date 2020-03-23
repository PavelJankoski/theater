package com.wpproject.theater.repositories;

import com.wpproject.theater.models.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {

    @Query("select distinct sr from SeatReservation sr where sr.showSeats.id=:showId")
    List<SeatReservation> showReservations(@Param("showId") long showId);

}

