package com.example.demo.conrollers;

import com.example.demo.model.FeedbackDTO;
import com.example.demo.services.feedbackservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Feedback")
public class Feedback {

    @Autowired
    private feedbackservices feedbackservices;

    @GetMapping("/all")
    public List<FeedbackDTO> allFeedbacks() {
        return feedbackservices.findAllFeedbacks();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody FeedbackDTO feedbackData) {
        return feedbackservices.saveFeedbacks(feedbackData);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody FeedbackDTO newfeedbackData) {
        return feedbackservices.updateFeedback(newfeedbackData);
    }

   // @GetMapping("find/{id}")
   // public Optional<FeedbackDTO> getFeedbackByName(@PathVariable String FullName) {
   //     return feedbackservices.findByFullName(FullName);
  //  }

   @DeleteMapping("/delete/{fid}")
     public String dltByFullName(@PathVariable Integer fid) {
      return feedbackservices.dltByFullName(fid);
   }

}
