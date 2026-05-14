package com.anishek.org.hospitalManagement.repository;

import com.anishek.org.hospitalManagement.dto.BloodGroupCountEntity;
import com.anishek.org.hospitalManagement.entity.Patient;
import com.anishek.org.hospitalManagement.entity.type.BloodGroupType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Patient findByBirthDate(LocalDate birthDate); // we write birthdate in camel case form BirthDate not like birthDate while using find

    List<Patient> findByBirthDateOrEmail(LocalDate birthdate ,  String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT p from Patient p WHERE p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("id") Long id, @Param("name") String name);

    //-------- PROJECTION --------
    @Query("SELECT new com.anishek.org.hospitalManagement.dto.BloodGroupCountEntity(p.bloodGroup, COUNT(p)) " +
            "FROM Patient p GROUP BY p.bloodGroup")
    List<BloodGroupCountEntity> countEachBloodGroupType();


    // ------- PAGINATION ------------
    @Query(value = "SELECT * FROM patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);
}
