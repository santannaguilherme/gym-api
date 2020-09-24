package com.trainingpal.gym.controller;

import com.trainingpal.gym.domain.dto.request.CoachRequest;
import com.trainingpal.gym.domain.dto.request.StudentRequest;
import com.trainingpal.gym.domain.dto.response.CoachResponse;
import com.trainingpal.gym.domain.dto.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping(value = "/{email}")
    public ResponseEntity<StudentResponse> getById(@PathVariable String email) {
        StudentResponse c = new StudentResponse();
        return ResponseEntity.ok(c);

    }

    @GetMapping()
    public ResponseEntity<List<StudentResponse>> list() {
        List<StudentResponse> l = new ArrayList<>();
        return ResponseEntity.ok(l);
    }

    @PostMapping
    public void post(@Valid @RequestBody StudentRequest model) {
    }
}
