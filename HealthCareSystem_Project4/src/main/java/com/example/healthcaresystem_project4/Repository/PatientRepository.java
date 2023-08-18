package com.example.healthcaresystem_project4.Repository;

import com.example.healthcaresystem_project4.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientById(Integer id);

    @Query("select p from Patient p where p.appointment = true ")
    List<Patient> getAllPatientWithAppintment();


//    @Query("select p from Patient p where p.PatientMoney")
//    Boolean checkPatientMoney(Integer bill, Double patientMoney);

    @Query("select p from Patient p where p.id =?1 and p.age < 18")
    Patient discountBillPatient(Integer id);
}
