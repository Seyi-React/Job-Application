package com.oluwaseyi.myjob.JobApplication.Review.service.impl;

import com.oluwaseyi.myjob.JobApplication.Review.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
}
