package com.patient.app.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Appointment {
	
	@Id
	private String appId;
	private String email;
	private String docId;
	private String docName;
	private String docSpecial;
	private String status;
	private String date;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(int count) {
		this.appId = Integer.toString(count);
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocSpecial() {
		return docSpecial;
	}
	public void setDocSpecial(String docSpecial) {
		this.docSpecial = docSpecial;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
