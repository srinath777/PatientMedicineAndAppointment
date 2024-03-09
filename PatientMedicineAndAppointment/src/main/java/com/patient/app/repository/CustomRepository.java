package com.patient.app.repository;

import java.util.List;

import com.patient.app.entity.Appointment;

public interface CustomRepository {
	
	public List<Appointment> findAllByEmail(String email);
}
