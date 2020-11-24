package com.trainingpal.gym.repository;

import com.trainingpal.gym.domain.entities.SiteRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRoleRepository extends JpaRepository<SiteRole, String> {



}