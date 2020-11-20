package com.trainingpal.gym.repository;

import java.util.Set;

import com.trainingpal.gym.domain.entities.SiteRole;
import com.trainingpal.gym.domain.entities.SiteUserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserRoleRepository extends JpaRepository<SiteUserRole, Integer> {

}