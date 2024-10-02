package com.oluwaseyi.myjob.JobApplication.company;

import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {
    List<Company> getAllCompany();
    boolean UpdateCompany(Company company, Long id);
}
