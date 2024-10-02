package com.oluwaseyi.myjob.JobApplication.controller;


import com.oluwaseyi.myjob.JobApplication.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/jobs")
public class JobController {


    @Autowired
   private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll () {
        jobService.findAll();
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Job job) {
        jobService.save(job);
        return new ResponseEntity<>("Job successfully added", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id) {
        Optional<Job> jobById = jobService.findById(id);

        if (jobById.isPresent()) {
            return new ResponseEntity<>(jobById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteById(id);

        if (isDeleted) {
            return new ResponseEntity<>("Job successfully deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> update( @PathVariable Long id,   @RequestBody Job updateJob) {
         boolean updated = jobService.updateJob(id,updateJob);
         if(updated) {
             return  new ResponseEntity<>("Job successfully updated", HttpStatus.OK);
         }
         return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}
