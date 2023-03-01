package com.litviniuk.project.EquipmentServiceApp.services;

import com.litviniuk.project.EquipmentServiceApp.models.Hospital;
import com.litviniuk.project.EquipmentServiceApp.repositories.HospitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddService {
    private final HospitalRepository hospitalRepository;

    public AddService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional
    public void addHospital (Hospital hospital){

        hospitalRepository.save(hospital);
    }

}
