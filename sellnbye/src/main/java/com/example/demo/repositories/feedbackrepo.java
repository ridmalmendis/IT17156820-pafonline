package com.example.demo.repositories;


import com.example.demo.model.FeedbackDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface feedbackrepo extends JpaRepository<FeedbackDTO,Integer> {


}
