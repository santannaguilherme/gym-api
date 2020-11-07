package com.trainingpal.gym.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.TrainnigRequest;
import com.trainingpal.gym.domain.dto.response.TrainnigResponse;

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
 * TrainnigController
 */

@RestController
@RequestMapping("/my-trainnig")
public class TrainnigController {
    @GetMapping()
    public ResponseEntity<List<TrainnigResponse>> list() {
        List<TrainnigResponse> l = new ArrayList<>();
        return ResponseEntity.ok(l);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainnigResponse> getById(@PathVariable int id) {
        TrainnigResponse c = new TrainnigResponse();
        return ResponseEntity.ok(c);

    }

    @DeleteMapping(value = "/{id}")
	public void deletById(@PathVariable Integer id) {
    }
    
    @PostMapping
	public ResponseEntity<TrainnigResponse> post(@Valid @RequestBody TrainnigRequest model) {
		
		return ResponseEntity.ok(new TrainnigResponse());
    }
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<TrainnigResponse> updateById(@PathVariable Integer id,
			@Valid @RequestBody TrainnigRequest model) {
		return ResponseEntity.ok(new TrainnigResponse());
	}

}