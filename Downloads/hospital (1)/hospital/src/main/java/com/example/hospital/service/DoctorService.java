package com.example.hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    // Register Doctor
    public String register(Doctor doctor) {

        Optional<Doctor> existingDoctor = repository.findByEmail(doctor.getEmail());

        if (existingDoctor.isPresent()) {
            return "Doctor already exists!";
        }

        repository.save(doctor);
        return "Doctor registered successfully!";
    }

    // Login Doctor
    public String login(String email, String password) {

        Optional<Doctor> doctor = repository.findByEmail(email);

        if (doctor.isPresent()) {

            if (doctor.get().getPassword().equals(password)) {
                return "Doctor Login Successful!";
            } else {
                return "Invalid Password!";
            }
        }

        return "Doctor Not Found!";
    }
}