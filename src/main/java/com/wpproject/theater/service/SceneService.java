package com.wpproject.theater.service;

import com.wpproject.theater.models.Scene;

import java.util.List;

public interface SceneService {
    List<Scene> getAllScenes();
    Scene createScene(Scene scene);
    Scene updateScene(Scene scene);
    void deleteScene(long id);
    Scene findSceneById(long id);
}
