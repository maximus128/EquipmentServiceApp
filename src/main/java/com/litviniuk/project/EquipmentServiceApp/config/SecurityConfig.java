package com.litviniuk.project.EquipmentServiceApp.config;

import com.litviniuk.project.EquipmentServiceApp.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig {

    private final AuthProviderImpl authProvider;

    @Autowired
    public SecurityConfig(AuthProviderImpl authProvider){
        this.authProvider = authProvider;
    }

    protected void configure (AuthenticationManagerBuilder authenticationManagerBuilder ) {
        authenticationManagerBuilder.authenticationProvider(authProvider);
    }
}
