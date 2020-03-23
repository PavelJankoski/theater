package com.wpproject.theater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int seatNo;

    private int seatRow;

    @ManyToOne
    @JoinColumn(name="scene_id")
    @JsonIgnore
    private Scene theScene;


    @JsonIgnore
    @OneToMany(mappedBy = "seats")
    private List<SeatReservation> seats;

}
