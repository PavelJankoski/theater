package com.wpproject.theater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private String director;

    private String setDesigner;

    private String costumeDesigner;

    @Column(name = "from_time")
    private LocalDateTime from;

    private int duration;

    @ManyToMany(targetEntity = Actor.class)
    private List<Actor> actors;

    @ManyToOne
    @JoinColumn(name="scene_id")
    private Scene scene;

    @OneToMany(mappedBy = "showRating")
    @JsonIgnore
    private List<Rating> showRating;

    @OneToMany(mappedBy = "showSeats", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatReservation> showSeats;

    @Lob
    private byte[] image;


}
