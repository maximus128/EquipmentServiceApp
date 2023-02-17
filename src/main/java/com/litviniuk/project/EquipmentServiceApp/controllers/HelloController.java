package com.litviniuk.project.EquipmentServiceApp.controllers;

import com.litviniuk.project.EquipmentServiceApp.security.AppUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/showAppUserInfo")
    public String showAppUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUserDetails appUserDetails = (AppUserDetails)authentication.getPrincipal();
        System.out.println(appUserDetails.getAppUser());

        return "hello";
    }
}
