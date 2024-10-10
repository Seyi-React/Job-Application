package com.oluwaseyi.myjob.JobApplication.Review.service.impl;


import com.oluwaseyi.myjob.JobApplication.Review.Review;
import com.oluwaseyi.myjob.JobApplication.Review.ReviewRepository;
import com.oluwaseyi.myjob.JobApplication.company.Company;
import com.oluwaseyi.myjob.JobApplication.company.CompanyRepository;
import com.oluwaseyi.myjob.JobApplication.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private  CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService =companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void addReviews(Long companyId, Review review) {
        Optional<Company> company =  companyService.findCompanyById(companyId);
        if(company.isPresent()) {
            review.setCompany(company.get());
            reviewRepository.save(review);
        }
    }
}
