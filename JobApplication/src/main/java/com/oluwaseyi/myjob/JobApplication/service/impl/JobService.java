package com.oluwaseyi.myjob.JobApplication.service.impl;

import com.oluwaseyi.myjob.JobApplication.controller.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void save(Job job);
     Job   findById (Long id);
     void deleteById(Long id);
}
