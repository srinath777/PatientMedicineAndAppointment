package com.patient.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.app.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
