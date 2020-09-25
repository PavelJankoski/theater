package com.wpproject.theater.web.rest;


import com.wpproject.theater.models.Scene;
import com.wpproject.theater.service.SceneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/scenes", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class SceneController {
    private final SceneService sceneService;


    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    @GetMapping
    public ResponseEntity<List<Scene>> listScenes(){
        return ResponseEntity.ok().body(sceneService.getAllScenes());
    }

    @GetMapping("/{sceneId}")
    public ResponseEntity<Scene> getSceneById(@PathVariable long sceneId){
        return ResponseEntity.ok().body(sceneService.findSceneById(sceneId));
    }

    @PostMapping
    public ResponseEntity<Scene> createScene(@RequestBody Scene scene){
        return ResponseEntity.ok().body(this.sceneService.createScene(scene, scene.getSeatsInRow()));
    }

    @PutMapping("/{sceneId}")
    public ResponseEntity<Scene> updateScene(@PathVariable long sceneId, @RequestBody Scene scene){
        scene.setId(sceneId);
        return ResponseEntity.ok().body(this.sceneService.updateScene(scene, sceneId));
    }

    @DeleteMapping("/{sceneId}")
    public HttpStatus deleteScene(@PathVariable long sceneId){
        this.sceneService.deleteScene(sceneId);
        return HttpStatus.OK;
    }
}
