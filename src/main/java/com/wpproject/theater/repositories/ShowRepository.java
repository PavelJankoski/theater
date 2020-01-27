package com.wpproject.theater.repositories;

import com.wpproject.theater.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, String> {
}
