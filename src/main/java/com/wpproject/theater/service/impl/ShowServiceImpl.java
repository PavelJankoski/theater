package com.wpproject.theater.service.impl;

import com.wpproject.theater.models.SeatReservation;
import com.wpproject.theater.models.Show;
import com.wpproject.theater.models.exceptions.InvalidShowNameException;
import com.wpproject.theater.repositories.SeatReservationRepository;
import com.wpproject.theater.repositories.ShowRepository;
import com.wpproject.theater.service.ShowService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;
    private final SeatReservationRepository seatReservationRepository;

    public ShowServiceImpl(ShowRepository showRepository, SeatReservationRepository seatReservationRepository) {
        this.showRepository = showRepository;
        this.seatReservationRepository = seatReservationRepository;
    }


    @Override
    public Page<Show> getAllShowsPaged(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        return showRepository.findAll(paging);

    }

    @Override
    public List<Show> getAllShows() {
        return this.showRepository.findAllByOrderByFrom();
    }

    @Override
    public Show createShow(Show show){
        this.showRepository.save(show);
        for(int i =0;i<show.getScene().getSeats().size();i++){
            SeatReservation sr = new SeatReservation();
            sr.setSeats(show.getScene().getSeats().get(i));
            sr.setShowSeats(show);
            sr.setFree(true);
            this.seatReservationRepository.save(sr);
        }

        return show;
    }

    @Override
    public Show updateShow(Show show) {
        Show s = this.showRepository.findById(show.getId()).orElseThrow(InvalidShowNameException::new);
        s.setTitle(show.getTitle());
        s.setDescription(show.getDescription());
        s.setDirector(show.getDirector());
        s.setSetDesigner(show.getSetDesigner());
        s.setCostumeDesigner(show.getCostumeDesigner());
        s.setFrom(show.getFrom());
        s.setDuration(show.getDuration());
        s.setScene(show.getScene());
        s.setActors(show.getActors());
        return this.showRepository.save(s);
    }
    @Override
    public Show findShowById(long id){
        return this.showRepository.findById(id).orElseThrow(InvalidShowNameException::new);
    }

    @Override
    public void deleteShow(long id) {
        Show s = this.showRepository.findById(id).orElseThrow(InvalidShowNameException::new);
        this.showRepository.delete(s);
    }

    @Override
    public void saveImage(long id, MultipartFile file) {
        try {
            Show show = this.showRepository.findById(id).orElseThrow(InvalidShowNameException::new);
            show.setImage(file.getBytes());
            showRepository.save(show);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Show> searchShow(String term) {
        return this.showRepository.findByTitleContainingIgnoreCase(term);
    }


}
