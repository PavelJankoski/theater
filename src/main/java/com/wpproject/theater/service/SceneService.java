package com.wpproject.theater.service;

import com.wpproject.theater.models.Scene;

import java.util.List;

public interface SceneService {
    List<Scene> getAllScenes();
    Scene createScene(Scene scene, int seatsInRow);
    Scene updateScene(Scene scene, long sceneId);
    void deleteScene(long id);
    Scene findSceneById(long id);
}
