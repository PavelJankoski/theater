package com.wpproject.theater.service;

import com.wpproject.theater.models.Show;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ShowService {
    List<Show> getAllShows(Integer pageNo, Integer pageSize, String sortBy);
    Show createShow(Show show);
    Show updateShow(Show show);
    void deleteShow(long id);
    Show findShowById(long id);
    void saveImage(long id, MultipartFile file);
}
