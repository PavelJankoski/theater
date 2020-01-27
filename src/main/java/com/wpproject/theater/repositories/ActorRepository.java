package com.wpproject.theater.repositories;

import com.wpproject.theater.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}