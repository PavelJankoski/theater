package com.wpproject.theater.models;

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

    @Lob
    private byte[] image;

    @ManyToMany(targetEntity = Actor.class)
    private List<Actor> actors;

    @ManyToOne
    @JoinColumn(name="scene_id")
    private Scene scene;

    @OneToMany
    private List<Rating> showRating;

}
