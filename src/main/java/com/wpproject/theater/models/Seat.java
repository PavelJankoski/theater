package com.wpproject.theater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
