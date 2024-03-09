package com.patient.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.app.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,String> {

}
