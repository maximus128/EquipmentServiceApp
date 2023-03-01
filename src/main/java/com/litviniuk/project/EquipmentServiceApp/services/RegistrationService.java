package com.litviniuk.project.EquipmentServiceApp.services;

import com.litviniuk.project.EquipmentServiceApp.models.AppUser;
import com.litviniuk.project.EquipmentServiceApp.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(AppUser appUser){
        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setRole("ROLE_USER");
        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);
    }
}
