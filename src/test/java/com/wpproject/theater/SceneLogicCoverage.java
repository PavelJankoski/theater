package com.wpproject.theater;

import com.wpproject.theater.models.Scene;
import com.wpproject.theater.service.SceneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SceneLogicCoverage {

    @Autowired
    private SceneService sceneService;


    @Test // a=T
    public void test1(){

        Scene scene3 = sceneService.findSceneById(3);
        Scene resultScene = sceneService.findSceneById(4);

        assertEquals(resultScene.getCapacity(), sceneService.updateScene(scene3, 4).getCapacity());
    }

    @Test   // a=F, isto i b=F
    public void test2(){
        Scene scene5 = sceneService.findSceneById(5);
        Scene resultScene = sceneService.findSceneById(10);

        assertEquals(scene5.getCapacity(), sceneService.updateScene(scene5, 10).getCapacity());
    }

    @Test // b=T
    public void test3(){
        Scene scene4 = sceneService.findSceneById(4);
        Scene resultScene = sceneService.findSceneById(3);

        assertEquals(resultScene.getCapacity(), sceneService.updateScene(scene4, 3).getCapacity());
    }

    @Test // c=T
    public void test4(){
        Scene scene4 = sceneService.findSceneById(4);
        Scene resultScene = sceneService.findSceneById(3);

        assertEquals(resultScene.getCapacity(), sceneService.updateScene(scene4, 3).getCapacity());
    }

    @Test // c=F
    public void test5(){
        Scene scene4 = sceneService.findSceneById(4);
        Scene resultScene = sceneService.findSceneById(3);

        assertEquals(resultScene.getCapacity(), sceneService.updateScene(scene4, 3).getCapacity());
    }

    @Test   // d=T
    public void test6(){
        Scene scene5 = sceneService.findSceneById(5);
        Scene resultScene = sceneService.findSceneById(10);

        assertEquals(scene5.getCapacity(), sceneService.updateScene(scene5, 10).getCapacity());
    }

    @Test   // d=F
    public void test7(){
        Scene scene5 = sceneService.findSceneById(5);
        Scene resultScene = sceneService.findSceneById(10);

        assertEquals(scene5.getCapacity(), sceneService.updateScene(scene5, 10).getCapacity());
    }

}
