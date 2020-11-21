package com.trainingpal.gym.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.dto.request.AthletesRequest;
import com.trainingpal.gym.domain.dto.request.ExercicesRequest;
import com.trainingpal.gym.domain.dto.request.TrainigRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.dto.response.AthletesResponse;
import com.trainingpal.gym.domain.entities.Athlete;
import com.trainingpal.gym.domain.entities.Training;
import com.trainingpal.gym.domain.entities.TrainingExercice;
import com.trainingpal.gym.domain.entities.User;
import com.trainingpal.gym.domain.mapper.ExerciceMapper;
import com.trainingpal.gym.domain.mapper.TrainingMapper;
import com.trainingpal.gym.domain.mapper.UserMapper;
import com.trainingpal.gym.repository.TrainingExerciceRepository;
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
    private final ExerciceMapper exerciceMapper;
    private final SiteUserService siteUserService;
    private final TrainingExerciceRepository trainingExerciceRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository, SiteUserService siteUserService,
            UserMapper userMapper, ExerciceMapper exerciceMapper,
            TrainingExerciceRepository trainingExerciceRepository) {
        this.trainingRepository = trainingRepository;
        this.trainingExerciceRepository = trainingExerciceRepository;
        this.exerciceMapper = exerciceMapper;
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
        
        User user = saveUser(model);

        List<TrainigRequest> list = new ArrayList<TrainigRequest>();
        list.add(model.getTrainingA());
        list.add(model.getTrainingB());
        list.add(model.getTrainingC());

        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, 30);

        

        List<Training> tList = new ArrayList<Training>();
        for (int i = 0; i < list.size(); i++) {
            Training t = new Training();
            String tainingType = "";
            t.setAthlete(user);
            t.setTeacher(siteUserService.findByEmail(teacherEmail));
            t.setActive(true);
            switch (i) {
            case 0:
                tainingType = "A";
                break;
            case 1:
                tainingType = "B";
                break;
            case 2:
                tainingType = "C";
                break;
            default:
                tainingType = "A";
                break;
            }
            t.setTrainingType(tainingType);
            t.setTrainingValidity(new Date(c.getTimeInMillis()));

            t = trainingRepository.save(t);
            tList.add(t);

            for(ExercicesRequest ex : list.get(i).getExercices()){
                saveExecise(ex,t);
            }

        }

        AthletesResponse athlete = new AthletesResponse();
        athlete.setUser(userMapper.toDto(user));

        return athlete;
    }


    public void saveExecise(ExercicesRequest ex, Training t){
        TrainingExercice exercice = new TrainingExercice();
        exercice.setExercice(exerciceMapper.fromDto(ex));
        exercice.setRepetions(ex.getRepetitions());
        exercice.setSeries(ex.getQuantity());
        exercice.setPreviousWeight(ex.getWeight());
        exercice.setWeight(ex.getWeight());
        exercice.setTraining(t);
        trainingExerciceRepository.save(exercice);
    }

    public User saveUser(AthletesRequest model) throws Exception {
        UsuarioCreateRequest newUser = userMapper.fromDtoAthlete(model);
        return siteUserService.createUser(newUser);
    }

    public Training athletePut(Integer id, Training newTraining) throws Exception {
        Training training = findById(id);
        training.setActive(newTraining.getActive());

        return trainingRepository.save(training);
    }

}