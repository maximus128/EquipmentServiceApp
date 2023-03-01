package com.litviniuk.project.EquipmentServiceApp.controllers;

import com.litviniuk.project.EquipmentServiceApp.models.AppUser;
import com.litviniuk.project.EquipmentServiceApp.services.RegistrationService;
import com.litviniuk.project.EquipmentServiceApp.utill.AppUserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AppUserValidator appUserValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(AppUserValidator appUserValidator, RegistrationService registrationService) {
        this.appUserValidator = appUserValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("appUser")AppUser appUser) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("appUser")@Valid AppUser appUser, BindingResult bindingResult){
        appUserValidator.validate(appUser, bindingResult);

        if (bindingResult.hasErrors()) {
            return "auth/registration";}

        registrationService.register(appUser);

        return "redirect:/auth/login";
    }

}
