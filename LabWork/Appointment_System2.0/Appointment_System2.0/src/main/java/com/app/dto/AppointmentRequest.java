package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequest {

    private String patientName;
    private String doctorName;
    private LocalDate date;
    private LocalTime time;
    
    public AppointmentRequest() {}
    
	public AppointmentRequest(String patientName, String doctorName, LocalDate date, LocalTime time) {
		super();
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
		this.time = time;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}

    
    // Getters and setters
}

