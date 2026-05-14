package com.anishek.org.hospitalManagement.service;

import com.anishek.org.hospitalManagement.entity.Insurance;
import com.anishek.org.hospitalManagement.entity.Patient;
import com.anishek.org.hospitalManagement.repository.InsuranceRepository;
import com.anishek.org.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance , Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new RuntimeException("Patient not found"));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bidirectional consistency maintainence

        return patient;
    }
}
