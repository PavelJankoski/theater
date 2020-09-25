package com.wpproject.theater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int capacity;

    private int seatsInRow;

    @JsonIgnore
    @OneToMany(mappedBy = "scene", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Show> shows = new ArrayList<Show>();


    @OneToMany(mappedBy = "theScene", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats = new ArrayList<Seat>();

    public Scene(String name, int capacity, int seatsInRow){
        this.name = name;
        this.capacity = capacity;
        this.seatsInRow = seatsInRow;
    }

}
