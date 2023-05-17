package fr.owen.facturier.controller;


import fr.owen.facturier.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    AdminRepository adminRepository;
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}