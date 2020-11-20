package com.trainingpal.gym.service;

import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.entities.Athlete;
import com.trainingpal.gym.repository.AthletesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * AthletesService
 */
@Service
public class AthletesService {

    private final AthletesRepository athletesRepository;
    private final PasswordEncoder passEncoder;

    @Autowired
    public AthletesService(AthletesRepository athletesRepository,
    PasswordEncoder passEncoder){
        this.athletesRepository = athletesRepository;
        this.passEncoder = passEncoder;
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
       Athlete athletes = athletesRepository.findByEmail(email);
        return athletes;
    }

    public Athlete ValidateUser(String email, String senha) throws Exception {
		Athlete user = athletesRepository.findByEmail(email);
	  if (passEncoder.matches(senha, user.getPassword())) {
		return user;
	  }
	  else
		throw new Exception("Usuário ou senha inexistentes");
	}
    
}