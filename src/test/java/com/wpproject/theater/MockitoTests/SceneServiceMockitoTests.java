package com.wpproject.theater.MockitoTests;

import com.wpproject.theater.models.Scene;
import com.wpproject.theater.service.SceneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SceneServiceMockitoTests {

    @Mock
    SceneService sceneService;

    //List<Scene> scenes = sceneService.getAllScenes();

    @Test
    public void testSeatNumber(){
        Scene s1 = new Scene("TestScene1", 30, 5);
        Scene s2 = new Scene("TestScene2", 20, 4);
        Scene s3 = new Scene("TestScene3", 30, 3);
        Mockito.when(sceneService.createScene(s1, 5)).thenReturn(s1);
        Mockito.when(sceneService.createScene(s1, 5)).thenReturn(s2);
        Mockito.when(sceneService.createScene(s1, 5)).thenReturn(s3);
        assertEquals(s1.getCapacity()+s2.getCapacity()+s3.getCapacity(), 80);
    }

}
