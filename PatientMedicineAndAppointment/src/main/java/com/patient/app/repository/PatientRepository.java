package com.patient.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.app.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,String> {

}
