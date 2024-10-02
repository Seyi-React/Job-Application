package com.oluwaseyi.myjob.JobApplication.service.impl;

import com.oluwaseyi.myjob.JobApplication.controller.Job;
import com.oluwaseyi.myjob.JobApplication.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

 private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }


    @Override
    public boolean deleteById(Long id) {
       try{
           jobRepository.deleteById(id);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> job = jobRepository.findById(id);

            if (job.isPresent()) {
                Job job1 = job.get();
                job1.setTitle(updateJob.getTitle());
                job1.setDescription(updateJob.getDescription());
                job1.setMaxSalary(updateJob.getMaxSalary());
                job1.setMinSalary(updateJob.getMinSalary());
                job1.setLocation(updateJob.getLocation());
                jobRepository.save(job1);
                return true;
            }



        return false;
    }

}
