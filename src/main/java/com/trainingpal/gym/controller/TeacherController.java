package com.trainingpal.gym.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.TeacherRequest;
import com.trainingpal.gym.domain.dto.response.TeacherResponse;
import com.trainingpal.gym.domain.entities.Teacher;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TeacherController
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @GetMapping()
    public ResponseEntity<List<TeacherResponse>> list() {
        List<TeacherResponse> l = new ArrayList<>();
        return ResponseEntity.ok(l);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TeacherResponse> getById(@PathVariable int id) {
        TeacherResponse c = new TeacherResponse();
        return ResponseEntity.ok(c);

    }

    @DeleteMapping(value = "/{id}")
	public void deletById(@PathVariable Integer id) {
    }
    
    @PostMapping
	public ResponseEntity<TeacherResponse> post(@Valid @RequestBody TeacherRequest model) {
		
		return ResponseEntity.ok(new TeacherResponse());
    }
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<TeacherResponse> updateById(@PathVariable Integer id,
			@Valid @RequestBody TeacherRequest model) {
		return ResponseEntity.ok(new TeacherResponse());
	}

}