package com.oluwaseyi.myjob.JobApplication.controller;


import com.oluwaseyi.myjob.JobApplication.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("*")
@RestController
public class JobController {


    @Autowired
   private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll () {
        jobService.findAll();
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> save(@RequestBody Job job) {
        jobService.save(job);
        return new ResponseEntity<>("Job successfully added", HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findById(@PathVariable  Long id) {
        Job jobById = jobService.findById(id);
        if(jobById != null) {
            return  new ResponseEntity<>(jobById, HttpStatus.OK);
        }
        return new ResponseEntity<>(jobById, HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
         jobService.deleteById(id);
        if(id != null) {
            return  new ResponseEntity<>("Job successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}
