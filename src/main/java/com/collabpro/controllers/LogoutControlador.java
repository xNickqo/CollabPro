package com.collabpro.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collabpro")
public class LogoutControlador {
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException{
        request.logout();
        return "redirect:/collabpro/login?logout=true";
    }

}
