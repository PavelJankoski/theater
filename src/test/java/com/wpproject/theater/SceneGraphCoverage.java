package com.wpproject.theater;

import com.wpproject.theater.models.Scene;
import com.wpproject.theater.models.exceptions.InvalidSceneNameException;
import com.wpproject.theater.repositories.SeatReservationRepository;
import com.wpproject.theater.service.SceneService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SceneGraphCoverage {

    @Autowired
    private SceneService sceneService;


    @Test
    void createScene_1(){
        Scene s = new Scene("TestCreateScene", 5, 5);
        assertEquals(s, sceneService.createScene(s, 5));
    }

    @Test
    void updateScene_1(){
        Scene s = sceneService.findSceneById(12);
        s.setName("UpdateScene1");
        assertEquals(sceneService.updateScene(s, 11), s);
    }

    @Test
    void updateScene_2(){
        Scene s = sceneService.findSceneById(12);
        s.setCapacity(6);
        assertEquals(sceneService.updateScene(s, 11), s);
    }
    @Test
    void updateScene_3(){
        Scene s = sceneService.findSceneById(12);
        s.setCapacity(4);
        assertEquals(sceneService.updateScene(s, 11), s);
    }
}
