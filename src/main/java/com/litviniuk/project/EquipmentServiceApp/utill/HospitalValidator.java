package com.litviniuk.project.EquipmentServiceApp.utill;

import com.litviniuk.project.EquipmentServiceApp.models.Hospital;
import com.litviniuk.project.EquipmentServiceApp.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class HospitalValidator implements Validator {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalValidator(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Hospital.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Hospital hospital = (Hospital) target;

        try{
            hospitalService.loadHospitalByHospitalName(hospital.getHospitalName());
        }
        catch (UsernameNotFoundException ignore){
            return;
        }
        errors.rejectValue("hospitalName", "", "Hospital with that name already exists");

    }
}
