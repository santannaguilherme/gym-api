package com.trainingpal.gym.repository;

import java.util.Optional;

import com.trainingpal.gym.domain.entities.SiteUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, Integer> {

    Optional<SiteUser> findByEmail(String email);

    Optional<SiteUser> findByEmailAndPassword(String email, String password);
}

