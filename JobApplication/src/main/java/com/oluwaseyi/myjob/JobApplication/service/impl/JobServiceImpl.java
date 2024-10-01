package com.oluwaseyi.myjob.JobApplication.service.impl;

import com.oluwaseyi.myjob.JobApplication.controller.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void save(Job job) {
      jobs.add(job);
    }

    @Override
    public Job findById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        jobs.removeIf(job -> job.getId().equals(id));

    }

}
