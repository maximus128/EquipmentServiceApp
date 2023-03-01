package com.litviniuk.project.EquipmentServiceApp.controllers;

import com.litviniuk.project.EquipmentServiceApp.models.Hospital;
import com.litviniuk.project.EquipmentServiceApp.services.AddService;
import com.litviniuk.project.EquipmentServiceApp.utill.HospitalValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add")
public class AddController {
    private final AddService addService;
    private final HospitalValidator hospitalValidator;

    @Autowired
    public AddController(AddService addService, HospitalValidator hospitalValidator) {
        this.addService = addService;
        this.hospitalValidator = hospitalValidator;
    }

    @GetMapping("/hospital")
    public String addPage(@ModelAttribute("hospital")Hospital hospital) {
        return "add/hospital";
    }

    @PostMapping("/hospital")
    public String performAddHospital(@ModelAttribute("hospital")@Valid Hospital hospital, BindingResult bindingResult) {
        hospitalValidator.validate(hospital, bindingResult);

        if (bindingResult.hasErrors()) {
            return "add/hospital";
        }

        addService.addHospital(hospital);

        return "redirect:/hello";
    }

}
