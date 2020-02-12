package com.wpproject.theater.repositories;

import com.wpproject.theater.models.Show;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShowRepository extends PagingAndSortingRepository<Show, Long> {

}
