package com.oluwaseyi.myjob.JobApplication.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CompanyService {
    List<Company> getAllCompany();
    boolean UpdateCompany(Company company, Long id);
    void  addCompanies(Company company);
    Optional<Company> findCompanyById(Long id);
}
