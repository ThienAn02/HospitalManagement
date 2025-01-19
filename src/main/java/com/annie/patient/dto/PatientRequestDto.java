package com.annie.patient.dto;

import com.annie.patient.entity.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PatientRequestDto {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Age is required")
    private int age;

    @NotBlank(message = "Gender is required")
    private Gender gender;
}
