package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.model.Doctor;
import com.example.hospital.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    // Registration API
    @PostMapping("/register")
    public String register(@RequestBody Doctor doctor) {
        return service.register(doctor);
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody Doctor doctor) {
        return service.login(doctor.getEmail(), doctor.getPassword());
    }

}