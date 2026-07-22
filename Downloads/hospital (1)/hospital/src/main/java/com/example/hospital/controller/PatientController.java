package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    // Registration API
    @PostMapping("/register")
    public String register(@RequestBody Patient patient) {
        return service.register(patient);
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody Patient patient) {
        return service.login(patient.getEmail(), patient.getPassword());
    }
   
}