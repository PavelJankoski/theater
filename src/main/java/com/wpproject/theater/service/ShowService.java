package com.wpproject.theater.service;

import com.wpproject.theater.models.Show;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ShowService {
    Page<Show> getAllShowsPaged(Integer pageNo, Integer pageSize, String sortBy);
    List<Show> getAllShows();
    Show createShow(Show show);
    Show updateShow(Show show);
    void deleteShow(long id);
    Show findShowById(long id);
    void saveImage(long id, MultipartFile file);
    List<Show> searchShow(String term);
}
