package com.wpproject.theater.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    private LocalDate date;

    private String director;

    private String setDesigner;

    @DateTimeFormat(pattern="HH:mm" )
    @Column(name = "from_time")
    private LocalTime from;

    @DateTimeFormat(pattern="HH:mm" )
    @Column(name = "to_time")
    private LocalTime to;

    @Lob
    private Byte[] image;

    @ManyToMany(targetEntity = Actor.class, fetch = FetchType.EAGER)
    List<Actor> actors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="scene_name")
    private Scene scene;

}
