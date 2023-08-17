package com.example.healthcaresystem_project4.Repository;

import com.example.healthcaresystem_project4.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientById(Integer id);

}
