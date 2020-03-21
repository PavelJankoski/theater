package com.wpproject.theater.service.impl;

import com.wpproject.theater.models.Scene;
import com.wpproject.theater.models.Seat;
import com.wpproject.theater.models.exceptions.InvalidSceneNameException;
import com.wpproject.theater.repositories.SceneRepository;
import com.wpproject.theater.service.SceneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneServiceImpl implements SceneService {

    private final SceneRepository sceneRepository;

    public SceneServiceImpl(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }

    @Override
    public List<Scene> getAllScenes() {
        return this.sceneRepository.findAll();
    }

    @Override
    public Scene createScene(Scene scene, int seatsInRow) {
        for(int i = 1;i<scene.getCapacity()+1;i++){
            Seat seat = new Seat();
            seat.setSeatNo(i!=seatsInRow?i%seatsInRow:seatsInRow);
            seat.setSeatRow(i!=seatsInRow ?((i/seatsInRow) + 1):(i/seatsInRow));
            seat.setTheScene(scene);
            scene.getSeats().add(seat);
        }
        return this.sceneRepository.save(scene);
    }

    @Override
    public Scene updateScene(Scene scene) {
        Scene s = this.sceneRepository.findById(scene.getId()).orElseThrow(InvalidSceneNameException::new);
        if(s.getCapacity()!=scene.getCapacity()){
            int capacity = s.getCapacity() - scene.getCapacity();
            if(capacity<0){
                for(int i = 0;i<Math.abs(capacity);i++){
                    Seat seat = new Seat();
                    seat.setSeatNo(s.getSeats().size());
                    seat.setTheScene(s);
                    s.getSeats().add(seat);
                }
            }
            else{
                for(int i =0;i<capacity;i++){
                    scene.getSeats().remove(scene.getSeats().size()-1);
                }
            }

        }
        s.setName(scene.getName());
        return this.sceneRepository.save(s);
    }

    @Override
    public void deleteScene(long id) {
        Scene s = this.sceneRepository.findById(id).orElseThrow(InvalidSceneNameException::new);
        this.sceneRepository.delete(s);
    }

    @Override
    public Scene findSceneById(long id) {
        return this.sceneRepository.findById(id).orElseThrow(InvalidSceneNameException::new);
    }
}
