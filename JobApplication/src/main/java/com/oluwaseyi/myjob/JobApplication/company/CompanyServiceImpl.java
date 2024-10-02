package com.oluwaseyi.myjob.JobApplication.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {



   private final CompanyRepository companyRepository;


    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }
}
