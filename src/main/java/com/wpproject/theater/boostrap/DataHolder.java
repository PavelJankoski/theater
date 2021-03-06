package com.wpproject.theater.boostrap;

import com.wpproject.theater.models.*;
import com.wpproject.theater.repositories.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
@Getter
public class DataHolder {
    private final ActorRepository actorRepository;
    private final SeatRepository seatRepository;
    private final SceneRepository sceneRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final SeatReservationRepository seatReservationRepository;


    public DataHolder(ActorRepository actorRepository, SeatRepository seatRepository, SceneRepository sceneRepository, UserRepository userRepository, ShowRepository showRepository, SeatReservationRepository seatReservationRepository) {
        this.actorRepository = actorRepository;
        this.seatRepository = seatRepository;
        this.sceneRepository = sceneRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.seatReservationRepository = seatReservationRepository;
    }

    @PostConstruct
    public void init(){
        Actor actor = new Actor();
        actor.setName("ActorName1");
        actor.setSurname("ActorSurame1");
        Actor actor2 = new Actor();
        actor2.setName("ActorName2");
        actor2.setSurname("ActorSurame2");
        Actor actor3 = new Actor();
        actor3.setName("ActorName3");
        actor3.setSurname("ActorSurame3");
        Actor actor4 = new Actor();
        actor4.setName("ActorName4");
        actor4.setSurname("ActorSurame4");
//        actorRepository.save(actor);
//        actorRepository.save(actor2);
//        actorRepository.save(actor3);
//        actorRepository.save(actor4);
        Scene scene = new Scene();
        scene.setCapacity(5);
        scene.setName("Scene1");
        Scene scene2 = new Scene();
        scene2.setCapacity(15);
        scene2.setName("Scene2");
        User user = new User();
        user.setName("Kire");
        user.setEmail("kire@hotmail.com");
        for(int i = 1;i<scene.getCapacity()+1;i++){
            Seat seat = new Seat();
            seat.setSeatNo(i%15);
            seat.setSeatRow((i/15) + 1);
            seat.setTheScene(scene);
            scene.getSeats().add(seat);
        }
        for(int i = 1;i<scene2.getCapacity()+1;i++){
            Seat seat = new Seat();
            seat.setSeatNo(i%15);
            seat.setSeatRow((i/15) + 1);
            seat.setTheScene(scene2);
            scene2.getSeats().add(seat);
        }
        scene.setSeatsInRow(1);
        scene2.setSeatsInRow(5);
//        this.sceneRepository.save(scene);
//        this.sceneRepository.save(scene2);
//        this.userRepository.save(user);
        Show s1 = new Show();
        Show s2 = new Show();
        Show s3 = new Show();
        Show s4 = new Show();

        s1.setTitle("Title1");
        s1.setDescription("Descirption1");
        s1.setDirector("DirectorName1 DirectorSurname1");
        s1.setSetDesigner("Set Designer1");
        s1.setCostumeDesigner("Costume designer1");
        s1.setFrom(LocalDateTime.of(2000,6,1,12,0));
        s1.setDuration(90);
        s1.setScene(scene);
        ArrayList<Actor> sActors = new ArrayList<>();
        sActors.add(actor);
        sActors.add(actor2);
        sActors.add(actor4);
        s1.setActors(sActors);

        s2.setTitle("Title2");
        s2.setDescription("Descirption2");
        s2.setDirector("DirectorName2 DirectorSurname2");
        s2.setSetDesigner("Set Designer2");
        s2.setCostumeDesigner("Costume designer2");
        s2.setFrom(LocalDateTime.of(2020,6,1,6,30));
        s2.setDuration(120);
        s2.setScene(scene2);
        ArrayList<Actor> sActors1 = new ArrayList<>();
        sActors1.add(actor);
        sActors1.add(actor3);
        s2.setActors(sActors1);
        s3.setTitle("Title3");
        s3.setDescription("Descirption3");
        s3.setDirector("DirectorName3 DirectorSurname3");
        s3.setSetDesigner("Set Designer3");
        s3.setCostumeDesigner("Costume designer3");
        s3.setFrom(LocalDateTime.of(2000,6,1,18,0));
        s3.setDuration(75);
        s3.setScene(scene);
        ArrayList<Actor> sActors2 = new ArrayList<>();
        sActors2.add(actor4);
        sActors2.add(actor3);
        s3.setActors(sActors2);
        s4.setTitle("Title4");
        s4.setDescription("Descirption4");
        s4.setDirector("DirectorName4 DirectorSurname4");
        s4.setSetDesigner("Set Designer4");
        s4.setCostumeDesigner("Costume designer4");
        s4.setFrom(LocalDateTime.of(2021,6,1,6,20));
        s4.setDuration(150);
        s4.setScene(scene);
        ArrayList<Actor> sActors3 = new ArrayList<>();
        sActors3.add(actor4);
        sActors3.add(actor2);
        s4.setActors(sActors3);
//        this.showRepository.save(s1);
//        this.showRepository.save(s2);
//        this.showRepository.save(s3);
//        this.showRepository.save(s4);
        for(int i =0;i<scene.getSeats().size();i++){
            SeatReservation sr = new SeatReservation();
            sr.setSeats(scene.getSeats().get(i));
            sr.setShowSeats(s1);
            sr.setFree(true);
//            this.seatReservationRepository.save(sr);
        }
        for(int i =0;i<scene2.getSeats().size();i++){
            SeatReservation sr = new SeatReservation();
            sr.setSeats(scene2.getSeats().get(i));
            sr.setShowSeats(s2);
            sr.setFree(true);
//            this.seatReservationRepository.save(sr);
        }
//        Seat s = this.seatRepository.findById((long)1).orElseThrow(InvalidUserIdException::new);
//        s.setUser(user);
//        this.seatRepository.save(s);
//        Show s5 = new Show();
//        Show s6 = new Show();
//        Show s7 = new Show();
//        Show s8 = new Show();
//        s5.setTitle("Maliot PRinc");
//        s5.setDescription("Opis1");
//        s5.setDirector("Tarantino");
//        s5.setSetDesigner("Zhelka");
//        s5.setCostumeDesigner("Oroskir");
//        s5.setFrom(LocalDateTime.of(2000,6,1,12,0));
//        s5.setDuration(90);
//        s5.setScene(scene);
//        ArrayList<Actor> sActors5 = new ArrayList<>();
//        sActors5.add(actor);
//        sActors5.add(actor2);
//        sActors5.add(actor4);
//        s5.setActors(sActors);
//        s6.setTitle("Ljubov i kazna");
//        s6.setDescription("Opis2");
//        s6.setDirector("Kaprio");
//        s6.setSetDesigner("Ovca");
//        s6.setCostumeDesigner("Peskir");
//        s6.setFrom(LocalDateTime.of(2020,6,1,6,30));
//        s6.setDuration(120);
//        s6.setScene(scene);
//        ArrayList<Actor> sActors6 = new ArrayList<>();
//        sActors6.add(actor);
//        sActors6.add(actor3);
//        s6.setActors(sActors1);
//        s7.setTitle("1001 nokj");
//        s7.setDescription("Opis3");
//        s7.setDirector("Pit");
//        s7.setSetDesigner("Koza");
//        s7.setCostumeDesigner("Sungjer");
//        s7.setFrom(LocalDateTime.of(2000,6,1,18,0));
//        s7.setDuration(75);
//        s7.setScene(scene);
//        ArrayList<Actor> sActors7 = new ArrayList<>();
//        sActors7.add(actor4);
//        sActors7.add(actor3);
//        s7.setActors(sActors2);
//        s8.setTitle("Koga lisjata pagjaat");
//        s8.setDescription("Opis4");
//        s8.setDirector("Vilis");
//        s8.setSetDesigner("Krava");
//        s8.setCostumeDesigner("Zhica");
//        s8.setFrom(LocalDateTime.of(2021,6,1,6,20));
//        s8.setDuration(150);
//        s8.setScene(scene);
//        ArrayList<Actor> sActors8 = new ArrayList<>();
//        sActors8.add(actor4);
//        sActors8.add(actor2);
//        s8.setActors(sActors3);
//        this.showRepository.save(s5);
//        this.showRepository.save(s6);
//        this.showRepository.save(s7);
//        this.showRepository.save(s8);
    }
}
