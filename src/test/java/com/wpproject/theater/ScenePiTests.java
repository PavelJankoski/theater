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
class ScenePiTests {

    @Autowired
    private SceneService sceneService;


    @Test
    void findSceneByIdTest(){
        assertEquals(30, sceneService.findSceneById(7).getCapacity());
    }


}
