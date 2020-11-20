package com.trainingpal.gym.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.dto.request.AthletesRequest;
import com.trainingpal.gym.domain.dto.request.TrainigRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.dto.response.AthletesResponse;
import com.trainingpal.gym.domain.entities.Athlete;
import com.trainingpal.gym.domain.entities.Training;
import com.trainingpal.gym.domain.entities.User;
import com.trainingpal.gym.domain.mapper.TrainingMapper;
import com.trainingpal.gym.domain.mapper.UserMapper;
import com.trainingpal.gym.repository.TrainingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TrainingService
 */
@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final UserMapper userMapper;
    private final TrainingMapper trainingMapper;
    private final SiteUserService siteUserService;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository, SiteUserService siteUserService,
            UserMapper userMapper, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
        this.userMapper = userMapper;
        this.siteUserService = siteUserService;
    }

    public List<Training> listAthletes() {
        return trainingRepository.findAll();
    }

    public Training findById(Integer id) throws Exception {
        Optional<Training> training = trainingRepository.findById(id);
        return training.orElseThrow(() -> new Exception("Training Not found"));
    }

    public AthletesResponse createAthlete(AthletesRequest model, String teacherEmail) throws Exception {
        UsuarioCreateRequest newUser = userMapper.fromDtoAthlete(model);
        User user = siteUserService.createUser(newUser);

        List<TrainigRequest> list = new ArrayList<TrainigRequest>();
        list.add(model.getTrainingA());
        list.add(model.getTrainingB());
        list.add(model.getTrainingC());

        Date d = new Date();
        Training t = new Training();
        t.setAthlete(user);
        t.setTeacher(siteUserService.findByEmail(teacherEmail));
        t.setActive(true);
        t.setTrainingType("A");
        t.setTrainingValidity(new Date(d.getTime() * 30 * 86400000));

       
        AthletesResponse athlete = new AthletesResponse();
        athlete.setUser(userMapper.toDto(user));
        athlete.setT(trainingRepository.save(t));
        return athlete;
    }

    public Training athletePut(Integer id, Training newTraining) throws Exception {
        Training training = findById(id);
        training.setActive(newTraining.getActive());

        return trainingRepository.save(training);
    }

}