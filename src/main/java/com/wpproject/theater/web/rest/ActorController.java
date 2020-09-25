package com.wpproject.theater.web.rest;


import com.wpproject.theater.models.Actor;
import com.wpproject.theater.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/actors", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<Actor>> listActors(){
        return ResponseEntity.ok().body(actorService.getAllActors());
    }

    @GetMapping("/{actorId}")
    public ResponseEntity<Actor> getActorById(@PathVariable long actorId){
        return ResponseEntity.ok().body(actorService.findActorById(actorId));
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor){
        return ResponseEntity.ok().body(this.actorService.createActor(actor));
    }

    @PutMapping("/{actorId}")
    public ResponseEntity<Actor> updateActor(@PathVariable long actorId, @RequestBody Actor actor){
        actor.setId(actorId);
        return ResponseEntity.ok().body(this.actorService.updateActor(actor));
    }

    @DeleteMapping("/{actorId}")
    public HttpStatus deleteActor(@PathVariable long actorId){
        this.actorService.deleteActor(actorId);
        return HttpStatus.OK;
    }

}
