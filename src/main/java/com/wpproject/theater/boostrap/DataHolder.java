package com.wpproject.theater.boostrap;

import com.wpproject.theater.models.Actor;
import com.wpproject.theater.repositories.ActorRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@Getter
public class DataHolder {
    private final ActorRepository actorRepository;

    public DataHolder(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @PostConstruct
    public void init() throws ParseException {
        Actor actor = new Actor(56, "Pavel", Calendar.getInstance());

        actorRepository.save(actor);

    }
}
