package com.patient.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.app.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,String>,CustomRepository,CustomTwo{

}
