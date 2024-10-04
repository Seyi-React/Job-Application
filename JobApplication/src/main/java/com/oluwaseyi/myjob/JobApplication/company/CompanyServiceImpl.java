package com.oluwaseyi.myjob.JobApplication.company;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean UpdateCompany(Company company, Long id) {
        Optional<Company> com = companyRepository.findById(id);

        if (com.isPresent()) {
            Company company1 = com.get();
            company1.setDescription(company.getDescription());
            company1.setName(company.getName());
            company1.setJobs(company.getJobs());


            companyRepository.save(company1);
            return true;
        }



        return false;
    }

    @Override
    public void addCompanies(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        Optional<Company> companyId = companyRepository.findById(id);
        return  companyId;
    }


}
