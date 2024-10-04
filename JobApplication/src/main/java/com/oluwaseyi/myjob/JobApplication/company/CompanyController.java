package com.oluwaseyi.myjob.JobApplication.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;


    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        List<Company> companies = companyService.getAllCompany();
        if (companies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id, @RequestBody Company company) {
        boolean updatedCompany = companyService.UpdateCompany(company, id);
        if (updatedCompany) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.addCompanies(company);
        return new ResponseEntity<>("Company successfully created",HttpStatus.CREATED);

    }

    public ResponseEntity<String> findCompanyById(@PathVariable Long id) {
      Optional<Company> companyId =  companyService.findCompanyById(id);

      if(companyId.isPresent()) {
          return new ResponseEntity<>("Company ID Successfully found", HttpStatus.OK);
      }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
