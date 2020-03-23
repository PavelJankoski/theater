package com.wpproject.theater.repositories;

import com.wpproject.theater.models.Show;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShowRepository extends PagingAndSortingRepository<Show, Long> {

    List<Show> findAllByOrderByFrom();


   List<Show> findByTitleContainingIgnoreCase(String title);
}
