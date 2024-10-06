package com.oluwaseyi.myjob.JobApplication.Review.service.impl;


import com.oluwaseyi.myjob.JobApplication.Review.Review;
import com.oluwaseyi.myjob.JobApplication.Review.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return List.of();
    }
}
