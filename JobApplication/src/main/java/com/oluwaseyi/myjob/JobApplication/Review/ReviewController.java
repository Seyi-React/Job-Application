package com.oluwaseyi.myjob.JobApplication.Review;


import com.oluwaseyi.myjob.JobApplication.Review.service.impl.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }


    @PostMapping("/reviews")
    public  ResponseEntity<String> addReviews (@PathVariable Long companyId, @RequestBody Review review) {
        reviewService.addReviews(companyId,review);
        return new ResponseEntity<>("Review successfully added", HttpStatus.OK);
    }
}
