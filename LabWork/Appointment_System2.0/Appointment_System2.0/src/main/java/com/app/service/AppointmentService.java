package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentRepository;
import com.app.dto.AppointmentRequest;
import com.app.entity.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(AppointmentRequest appointmentRequest) throws Exception {
        // Create a new Appointment object from the appointmentRequest
        Appointment appointment = new Appointment();
        appointment.setPatientName(appointmentRequest.getPatientName());
        appointment.setDoctorName(appointmentRequest.getDoctorName());
        appointment.setDate(appointmentRequest.getDate());
        appointment.setTime(appointmentRequest.getTime());

        // Save the appointment in the database
        try {
            appointment = appointmentRepository.save(appointment);
            return appointment;
        } catch (Exception e) {
            throw new Exception("Error creating appointment: " + e.getMessage());
        }
    }

    public List<Appointment> getUpcomingAppointments(String userId) throws Exception {
        try {
            // Retrieve the upcoming appointments for the given userId
            List<Appointment> appointments = appointmentRepository.findUpcomingAppointmentsByUserId(userId);
            return appointments;
        } catch (Exception e) {
            throw new Exception("Error retrieving upcoming appointments: " + e.getMessage());
        }
    }

    public void cancelAppointment(Long appointmentId) throws Exception {
        try {
            // Retrieve the appointment by appointmentId
            Appointment appointment = appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new Exception("Appointment not found with ID: " + appointmentId));

            // Delete the appointment from the database
            appointmentRepository.delete(appointment);
        } catch (Exception e) {
            throw new Exception("Error canceling appointment: " + e.getMessage());
        }
    }
}


