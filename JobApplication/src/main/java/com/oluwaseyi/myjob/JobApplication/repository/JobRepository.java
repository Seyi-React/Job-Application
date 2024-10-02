package com.oluwaseyi.myjob.JobApplication.repository;

import com.oluwaseyi.myjob.JobApplication.controller.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
