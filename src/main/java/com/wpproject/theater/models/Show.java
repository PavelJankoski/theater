package com.wpproject.theater.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Show {
    @Id
    private String title;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String director;

    private String setDesigner;

    private int duration;

    @ManyToMany(targetEntity = Actor.class, fetch = FetchType.EAGER)
    List<Actor> actors;

    @ManyToOne(fetch = FetchType.LAZY)
    private Scene scene;

}
