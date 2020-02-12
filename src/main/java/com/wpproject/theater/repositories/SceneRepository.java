package com.wpproject.theater.repositories;

import com.wpproject.theater.models.Scene;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SceneRepository extends JpaRepository<Scene, Long> {
}
