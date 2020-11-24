package com.trainingpal.gym.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SiteRole
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteRole implements GrantedAuthority {

  /**
   *
   */
  private static final long serialVersionUID = -1702117189815215655L;
  @Id
  private String name;

  @Override
  public String getAuthority() {
    return this.getName();
  }
    
}