package com.wpproject.theater.repositories;

import com.wpproject.theater.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
