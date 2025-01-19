package com.annie.patient.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "age", nullable = false)
    private int age;

    @NotNull
    @Column(name="gender", nullable = false)
    private  Gender gender;

    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;
}
