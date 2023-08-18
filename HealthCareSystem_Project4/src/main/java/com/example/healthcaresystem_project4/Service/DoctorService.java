package com.example.healthcaresystem_project4.Service;

import com.example.healthcaresystem_project4.Api.ApiException;
import com.example.healthcaresystem_project4.Model.Doctor;
import com.example.healthcaresystem_project4.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }
    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public void updateDoctor(Integer id, Doctor doctor){
        Doctor oldDoctor = doctorRepository.findDoctorById(id);

        if (oldDoctor == null)
            throw new ApiException("Doctor id is wrong");

        oldDoctor.setName(doctor.getName());
        oldDoctor.setPhoneNo(doctor.getPhoneNo());
        oldDoctor.setPosition(doctor.getPosition());
        oldDoctor.setSalary(doctor.getSalary());

        doctorRepository.save(oldDoctor);
    }

    public void deleteDoctor(Integer id){
        Doctor deleteDoctor = doctorRepository.findDoctorById(id);

        if (deleteDoctor == null)
            throw new ApiException("Sorry, the doctor id is wrong");

        doctorRepository.delete(deleteDoctor);
    }

}
