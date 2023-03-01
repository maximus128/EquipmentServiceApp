package com.litviniuk.project.EquipmentServiceApp.services;

import com.litviniuk.project.EquipmentServiceApp.models.Hospital;
import com.litviniuk.project.EquipmentServiceApp.repositories.HospitalRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    public Hospital loadHospitalByHospitalName(String hospitalName) throws UsernameNotFoundException {
        Optional<Hospital> hospital = hospitalRepository.findByHospitalName(hospitalName);

        if (hospital.isEmpty())
            throw new UsernameNotFoundException("Hospital not found!");
        return hospital.get();
    }
}
