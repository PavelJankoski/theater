package com.wpproject.theater.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="show_id")
    private Show showSeats;

    @ManyToOne
    @JoinColumn(name="seat_id")
    private Seat seats;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private boolean isFree;

}
