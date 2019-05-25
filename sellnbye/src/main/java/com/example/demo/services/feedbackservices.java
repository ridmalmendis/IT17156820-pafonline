package com.example.demo.services;

import com.example.demo.model.FeedbackDTO;

import java.util.List;
import java.util.Optional;

public interface feedbackservices {

    List<FeedbackDTO> findAllFeedbacks();

    String saveFeedbacks(FeedbackDTO feedbackData);

    String updateFeedback(FeedbackDTO newfeedbackData);

    Optional<FeedbackDTO> findByFullName(int fid);

    String dltByFullName(Integer fid);

}
