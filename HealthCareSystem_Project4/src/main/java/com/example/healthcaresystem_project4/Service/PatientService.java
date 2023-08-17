package com.example.healthcaresystem_project4.Service;

import com.example.healthcaresystem_project4.Api.ApiException;
import com.example.healthcaresystem_project4.Model.Patient;
import com.example.healthcaresystem_project4.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void updatePatient(Integer id, Patient patient){
        Patient oldPatient = patientRepository.findPatientById(id);

        if (oldPatient == null)
            throw new ApiException("Sorry, patient id is wrong");

        oldPatient.setName(patient.getName());
        oldPatient.setAge(patient.getAge());
        oldPatient.setPhoneNo(patient.getPhoneNo());
        oldPatient.setPatientMoney(patient.getPatientMoney());
        oldPatient.setAppointment(patient.getAppointment());


        patientRepository.save(oldPatient);
    }

    public void deletePatient(Integer id){
        Patient deletePatient = patientRepository.findPatientById(id);

        if (deletePatient == null)
            throw new ApiException("Sorry, patient id is wrong");

        patientRepository.delete(deletePatient);
    }


}
