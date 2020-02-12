package com.wpproject.theater.boostrap;

import com.wpproject.theater.models.*;
import com.wpproject.theater.repositories.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.time.LocalDate;

@Component
@Getter
public class DataHolder {
    private final ActorRepository actorRepository;
    private final SeatRepository seatRepository;
    private final SceneRepository sceneRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    public DataHolder(ActorRepository actorRepository, SeatRepository seatRepository, SceneRepository sceneRepository, UserRepository userRepository, ShowRepository showRepository) {
        this.actorRepository = actorRepository;
        this.seatRepository = seatRepository;
        this.sceneRepository = sceneRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    @PostConstruct
    public void init() throws ParseException {
        Actor actor = new Actor();
        actor.setName("Pavel");
        actor.setSurname("Jankoski");
        actor.setBirthday(LocalDate.of(1999,6,1));

        actorRepository.save(actor);
        Scene scene = new Scene();
        scene.setCapacity(5);
        scene.setName("PrvaScena");
        User user = new User();
        user.setName("Pavel");
        user.setEmail("pavel@hotmail.com");
        for(int i = 1;i<scene.getCapacity()+1;i++){
            Seat seat = new Seat();
            seat.setSeatNo(i);
            seat.setTheScene(scene);
            scene.getSeats().add(seat);
        }
        this.sceneRepository.save(scene);
        this.userRepository.save(user);
        Show s1 = new Show();
        Show s2 = new Show();
        Show s3 = new Show();
        Show s4 = new Show();
        s1.setDate(LocalDate.of(1999,6,1));
        s2.setDate(LocalDate.of(1995,6,1));
        s3.setDate(LocalDate.of(2000,6,1));
        s4.setDate(LocalDate.of(1998,6,1));
        this.showRepository.save(s1);
        this.showRepository.save(s2);
        this.showRepository.save(s3);
        this.showRepository.save(s4);
//        Seat s = this.seatRepository.findById((long)1).orElseThrow(InvalidUserIdException::new);
//        s.setUser(user);
//        this.seatRepository.save(s);
    }
}
