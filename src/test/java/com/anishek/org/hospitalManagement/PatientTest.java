package com.anishek.org.hospitalManagement;

import com.anishek.org.hospitalManagement.dto.BloodGroupCountEntity;
import com.anishek.org.hospitalManagement.entity.Patient;
import com.anishek.org.hospitalManagement.entity.type.BloodGroupType;
import com.anishek.org.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        //List<Patient> patientList = patientRepository.findAll() ;
        //System.out.println(patientList);

        Patient p1 = new Patient();
        patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethods(){
        //Patient patient = patientRepository.findByName("Divya");
        //Patient patient2 = patientRepository.findByBirthDate(LocalDate.of(2004,01,29));
        //System.out.println(patient);
        //System.out.println(patient2);
        //List<Patient> patientlist = patientRepository.findByBirthDateOrEmail(LocalDate.of(2004,01,29), "divya@gmail.com");

        //List<Patient> patientlist = patientRepository.findByBirthDateBetween(LocalDate.of(2002,01,01),LocalDate.of(2004,02,01));

        //List<Patient> patientlist = patientRepository.findByBloodGroup(BloodGroupType.A_Positive);

        //List<Patient> patientlist = patientRepository.findByBornAfterDate(LocalDate.of(2002,01,01));
        //for(Patient p:patientlist){
        //    System.out.println(p);
        //}

        //int rowsUpdated = patientRepository.updateNameWithId(4L , "Manish");
        //System.out.println(rowsUpdated);

        //List<BloodGroupCountEntity> bloodgrouplist = patientRepository.countEachBloodGroupType();
        //for(BloodGroupCountEntity bloodgroup : bloodgrouplist){
        //    System.out.println(bloodgroup);
        //}


        //-------- PAGEABLE -------
        //Page<Patient> patientlist = patientRepository.findAll(PageRequest.of(0, 2));
        //for(Patient patient : patientlist){
        //    System.out.println(patient);
        //}
    }
}
