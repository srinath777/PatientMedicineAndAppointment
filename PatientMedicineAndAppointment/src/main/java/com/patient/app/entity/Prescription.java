package com.patient.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String issue;
    private String medicine;
    private boolean injectionNeeded;
    private String comments;

    public Prescription(Long id, String patientName,
                        String issue, String medicine,
                        boolean injectionNeeded, String comments) {
        this.id = id;
        this.patientName = patientName;
        this.issue = issue;
        this.medicine = medicine;
        this.injectionNeeded = injectionNeeded;
        this.comments = comments;
    }

    public Prescription(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public boolean isInjectionNeeded() {
        return injectionNeeded;
    }

    public void setInjectionNeeded(boolean injectionNeeded) {
        this.injectionNeeded = injectionNeeded;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
