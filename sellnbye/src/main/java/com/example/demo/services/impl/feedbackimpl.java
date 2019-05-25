package com.example.demo.services.impl;

//import com.example.demo.conrollers.enums.FeedbackType;
import com.example.demo.model.FeedbackDTO;
import com.example.demo.repositories.feedbackrepo;
import com.example.demo.services.feedbackservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class feedbackimpl implements feedbackservices{

    @Autowired
    private feedbackrepo feedbackrepo;

    @Override
    public List<FeedbackDTO> findAllFeedbacks() {

        List<FeedbackDTO> allFeedbacks = feedbackrepo.findAll();
        return allFeedbacks;
    }

    @Override
    public String saveFeedbacks(FeedbackDTO feedbackData) {
        feedbackrepo.save(feedbackData);

        return "Successfully Saved.";
    }

    @Override
    public String updateFeedback(FeedbackDTO newfeedbackData) {

        String msg = null;
        if(newfeedbackData.getFid()!= null)
        {
            feedbackrepo.save(newfeedbackData);
            msg = "Successfully Updated.";
        } else
        {
            msg = "Update Error";
        }

        return msg;
    }

    @Override
    public Optional<FeedbackDTO> findByFullName(int FullName) {

        Optional<FeedbackDTO> sortFeedbacks = feedbackrepo.findById(FullName);
        return sortFeedbacks;
    }

    @Override
    public String dltByFullName(Integer fid) {

       String msg = null;
      if (fid != null)
        {
            feedbackrepo.deleteById(fid);
            msg = "Successfully Deleted.";
       }else
        {
            msg = "Deletion Error";
       }
        return msg;
   }
}