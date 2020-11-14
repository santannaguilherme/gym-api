package com.trainingpal.gym.service;

import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.entities.Athlete;
import com.trainingpal.gym.repository.AthletesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AthletesService
 */
@Service
public class AthletesService {

    private final AthletesRepository athletesRepository;

    @Autowired
    public AthletesService(AthletesRepository athletesRepository){
        this.athletesRepository = athletesRepository;
    }
    
    public List<Athlete> listAthletes() {
        return athletesRepository.findAll();
    }

    public Athlete findById(Integer id) throws Exception {
        Optional<Athlete> athletes = athletesRepository.findById(id);
        return athletes.orElseThrow(() -> new Exception("Athelte Not found"));
    }

    public Athlete createAthlete(Athlete model) {
        return athletesRepository.save(model);
    }

    public Athlete athletePut(String email, Athlete newAthelte) throws Exception {
        Athlete athlete = findByEmail(email);
        athlete.setName(newAthelte.getName());
        athlete.setEmail(newAthelte.getEmail());
        athlete.setAge(newAthelte.getAge());
        athlete.setHeight(newAthelte.getHeight());
        athlete.setWeight(newAthelte.getWeight());
        athlete.setPhone(newAthelte.getPhone());

        return athletesRepository.save(athlete);
    }

    private Athlete findByEmail(String email) throws Exception {
        Optional<Athlete> athletes = athletesRepository.findByEmail(email);
        return athletes.orElseThrow(() -> new Exception("Athelte Not found"));
    }
    
}