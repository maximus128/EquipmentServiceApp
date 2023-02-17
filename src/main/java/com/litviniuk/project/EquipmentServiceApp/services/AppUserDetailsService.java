package com.litviniuk.project.EquipmentServiceApp.services;

import com.litviniuk.project.EquipmentServiceApp.models.AppUser;
import com.litviniuk.project.EquipmentServiceApp.repositories.AppUserRepository;
import com.litviniuk.project.EquipmentServiceApp.security.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserDetailsService (AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;

    }

    @Override
    public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = appUserRepository.findByUsername(username);

        if (appUser.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new AppUserDetails(appUser.get());
    }
}
