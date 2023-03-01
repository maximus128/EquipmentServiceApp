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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUserDetails appUserDetails = (AppUserDetails)authentication.getPrincipal();
        if (appUserDetails.getAppUser().getRole().equals("ROLE_ADMIN"))
            return "admin/hello";
        else if (appUserDetails.getAppUser().getRole().equals("ROLE_MANAGER"))
            return "manager/hello";
        else if (appUserDetails.getAppUser().getRole().equals("ROLE_CUSTOMER"))
            return "customer/hello";
        else
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
