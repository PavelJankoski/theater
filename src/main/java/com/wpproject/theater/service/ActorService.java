package com.wpproject.theater.service;

import com.wpproject.theater.models.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAllActors();
    Actor createActor(Actor actor);
    Actor updateActor(Actor actor);
    void deleteActor(long id);
    Actor findActorById(long id);
}
