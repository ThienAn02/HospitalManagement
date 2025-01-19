package com.annie.patient.service;

import com.annie.patient.dto.PatientRequestDto;
import com.annie.patient.dto.PatientResponseDto;
import com.annie.patient.entity.Patient;

import java.util.List;

public interface PatientMapper {
    Patient toEntity(PatientRequestDto patientRequestDTO);

    PatientResponseDto toResponseDTO(Patient patient);

    List<PatientResponseDto> toResponseDTOList(List<Patient> patients);
}
