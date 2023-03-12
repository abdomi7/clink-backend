package com.abdelhalim.egypt.clinics.clinic.repository;

import com.abdelhalim.egypt.clinics.clinic.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
}