package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.AppointmentRequest;
import com.app.entity.Appointment;
import com.app.service.AppointmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequest appointmentDTO) throws Exception {
        Appointment appointment = appointmentService.createAppointment(appointmentDTO);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/upcoming")
    public ResponseEntity<List<Appointment>> getUpcomingAppointments(@PathVariable("userId") String userId) throws Exception {
        List<Appointment> upcomingAppointments = appointmentService.getUpcomingAppointments(userId);
        return new ResponseEntity<>(upcomingAppointments, HttpStatus.OK);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> cancelAppointment(@PathVariable("appointmentId") Long appointmentId) throws Exception {
        appointmentService.cancelAppointment(appointmentId);
        return new ResponseEntity<>("Appointment canceled successfully", HttpStatus.OK);
    }
}
