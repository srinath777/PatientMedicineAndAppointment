package com.patient.app.repository;

import java.util.List;

import com.patient.app.entity.Appointment;

public interface CustomTwo {
	
	public List<Appointment> findByDocId(String docId);
}
