package com.wpproject.theater.service.impl;

import com.wpproject.theater.models.Actor;
import com.wpproject.theater.models.exceptions.InvalidActorIdException;
import com.wpproject.theater.repositories.ActorRepository;
import com.wpproject.theater.service.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> getAllActors() {
        return this.actorRepository.findAll();
    }

    @Override
    public Actor createActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    @Override
    public Actor updateActor(Actor actor) {
        Actor a = this.actorRepository.findById(actor.getId()).orElseThrow(InvalidActorIdException::new);
        a.setName(actor.getName());
        a.setSurname(actor.getSurname());
        a.setBirthday(actor.getBirthday());
        return this.actorRepository.save(a);
    }

    @Override
    public void deleteActor(long id) {
        Actor a = this.actorRepository.findById(id).orElseThrow(InvalidActorIdException::new);
        this.actorRepository.delete(a);
    }

    @Override
    public Actor findActorById(long id) {
        return this.actorRepository.findById(id).orElseThrow(InvalidActorIdException::new);
    }
}
