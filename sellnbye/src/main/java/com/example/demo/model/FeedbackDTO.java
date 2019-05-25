package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "feedbackttb")
public class FeedbackDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "Feedback_id")
    private Integer fid;
    @Column(name = "Full_name")
    private String fFullName;
    @Column(name = "email")
    private String fEmail;
    @Column(name = "Description")
    private String fDescription;


    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getfFullName() {
        return fFullName;
    }

    public void setfFullName(String fFullName) {
        this.fFullName = fFullName;
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getfDescription() {
        return fDescription;
    }

    public void setfDescription(String fDescription) {
        this.fDescription = fDescription;
    }
}
