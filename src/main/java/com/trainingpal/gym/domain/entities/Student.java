package com.trainingpal.gym.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 60)
    private String name;

    @Column(name = "Age", nullable = false)
    private Double age;

    @Column(name = "Weight", nullable = false)
    private Double weight;

    @Column(name = "Email", nullable = false, length = 80)
    private String email;

    @Column(name = "Height", nullable = false)
    private Double height;

    @Column(name = "Phone", nullable = false, length = 80)
    private String phone;

    @Column(name = "RG", nullable = false, length = 11)
    private String rg;

    @Column(name = "Address", nullable = false, length = 120)
    private String address;

    @Column(name = "BegginingDate", nullable = false)
    private Date begginingDate;
} 