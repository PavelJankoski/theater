package com.wpproject.theater.models;

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
    private int id;

    private int seatNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Scene sceneS;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
