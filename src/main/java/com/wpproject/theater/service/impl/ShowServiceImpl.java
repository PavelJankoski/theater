package com.wpproject.theater.service.impl;

import com.wpproject.theater.models.Show;
import com.wpproject.theater.models.exceptions.InvalidShowNameException;
import com.wpproject.theater.models.exceptions.InvalidTimeException;
import com.wpproject.theater.repositories.ShowRepository;
import com.wpproject.theater.service.ShowService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }


    @Override
    public List<Show> getAllShows(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        Page<Show> pagedResult = showRepository.findAll(paging);
        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }
        else{
            return new ArrayList<Show>();
        }
    }

    @Override
    public Show createShow(Show show) {
        return this.showRepository.save(show);
    }

    @Override
    public Show updateShow(Show show) {
        Show s = this.showRepository.findById(show.getId()).orElseThrow(InvalidShowNameException::new);
        if(show.getFrom().isAfter(show.getTo())){
            throw new InvalidTimeException();
        }
        s.setDescription(show.getDescription());
        s.setDate(show.getDate());
        s.setDirector(show.getDirector());
        s.setSetDesigner(show.getSetDesigner());
        s.setFrom(show.getFrom());
        s.setTo(show.getTo());
        s.setScene(show.getScene());
        s.setActors(show.getActors());
        s.setImage(show.getImage());
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
    @Transactional
    public void saveImage(long id, MultipartFile file) {
        try {
            Show show = showRepository.findById(id).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0;
            for(byte b : file.getBytes()){
                byteObjects[i++] = b;
            }
            show.setImage(byteObjects);
            showRepository.save(show);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
