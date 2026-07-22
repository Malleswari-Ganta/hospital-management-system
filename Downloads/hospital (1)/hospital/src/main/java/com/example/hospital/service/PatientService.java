package com.example.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    // Registration
    public String register(Patient patient) {

        Patient p = repo.findByEmail(patient.getEmail());

        if (p != null) {
            return "Email already exists";
        }

        repo.save(patient);
        return "Registration Successful";
    }

    // Login
    public String login(String email, String password) {

        Patient p = repo.findByEmailAndPassword(email, password);

        if (p != null) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}
