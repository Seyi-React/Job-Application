package com.oluwaseyi.myjob.JobApplication.service.impl;

import com.oluwaseyi.myjob.JobApplication.controller.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    void save(Job job);
     Optional<Job> findById (Long id);
     boolean deleteById(Long id);

    boolean updateJob(Long id, Job updateJob);
}
