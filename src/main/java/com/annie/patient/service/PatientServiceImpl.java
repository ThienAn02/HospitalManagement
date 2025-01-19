package com.annie.patient.service;
import com.annie.patient.dao.PatientDao;
import com.annie.patient.dto.PatientRequestDto;
import com.annie.patient.dto.PatientResponseDto;
import com.annie.patient.entity.Patient;


import jakarta.inject.Inject;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Inject
    private PatientDao patientDao;

    @Inject
    private PatientMapper patientMapper;

    @Override
    public PatientResponseDto getPatientById(Long id) {
        Patient patient = patientDao.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        return patientMapper.toResponseDTO(patient);
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        List<Patient> patients = patientDao.findAll(); // Ensure this method is properly implemented
        return patientMapper.toResponseDTOList(patients);
    }

    @Override
    public PatientResponseDto addPatient(PatientRequestDto patientRequest) {
        Patient patient = patientMapper.toEntity(patientRequest);
        Patient savedPatient = patientDao.save(patient);
        return patientMapper.toResponseDTO(savedPatient);
    }

    @Override
    public PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequest) {
        Patient existingPatient = patientDao.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        existingPatient.setName(patientRequest.getName());
        existingPatient.setAddress(patientRequest.getAddress());
        existingPatient.setAge(patientRequest.getAge());
        existingPatient.setGender(patientRequest.getGender());
        Patient updatedPatient = patientDao.save(existingPatient);
        return patientMapper.toResponseDTO(updatedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientDao.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        patientDao.delete(id);
    }
}
