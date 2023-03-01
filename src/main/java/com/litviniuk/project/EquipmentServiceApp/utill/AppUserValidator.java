package com.litviniuk.project.EquipmentServiceApp.utill;

import com.litviniuk.project.EquipmentServiceApp.models.AppUser;
import com.litviniuk.project.EquipmentServiceApp.services.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AppUserValidator implements Validator {

    private final AppUserDetailsService appUserDetailsService;

    @Autowired
    public AppUserValidator (AppUserDetailsService appUserDetailsService){
        this.appUserDetailsService = appUserDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AppUser.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AppUser appUser = (AppUser) target;

        try{
            appUserDetailsService.loadUserByUsername(appUser.getUsername());
        }
        catch (UsernameNotFoundException ignore){
            return;
        }

        errors.rejectValue("username", "", "Person with that name already exists");
    }
}
