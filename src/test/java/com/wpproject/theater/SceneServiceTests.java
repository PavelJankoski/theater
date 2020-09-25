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
class SceneServiceTests {

    @Autowired
    private SceneService sceneService;

    @BeforeEach
    public void testStarted(){
        System.out.println("Test started!");
    }

    @AfterEach
    public void testEnded(){
        System.out.println("Test ended successfully!");
    }

    public static Collection<Object[]> testScenesCreated(){
        return Arrays.asList(new Object[][] {
                { new Scene("Scene1", 10, 2), 2 },
                { new Scene("Scene2", 20, 4), 4 },
                { new Scene("Scene1", 30, 5), 5 }
        });
    }

    @ParameterizedTest
    @MethodSource("testScenesCreated")
    public void scenesCreatedTest(Scene scene, int seatsInRow) {
        assertEquals(scene,sceneService.createScene(scene, seatsInRow));
    }

    @Test
    void getAllScenesTest() {
        assertEquals(3, sceneService.getAllScenes().size());
    }

    @Test
    void sceneNotFoundTest(){
        assertThrows(InvalidSceneNameException.class, ()-> sceneService.findSceneById(100));
    }

    @Test
    void deleteSceneTest(){
        sceneService.deleteScene(12);
        assertThrows(InvalidSceneNameException.class, ()-> sceneService.findSceneById(6));

    }

    @Test
    void findSceneByIdTest(){
        assertEquals(30, sceneService.findSceneById(7).getCapacity());
    }

    @Test
    void updateSceneTest(){
        Scene s1 = sceneService.findSceneById(1);
        sceneService.updateScene(s1, 2);
        Scene s2 = sceneService.findSceneById(2);
        assertEquals(s1.getName(),s2.getName());
    }

}
