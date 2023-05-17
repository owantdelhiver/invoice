package fr.owen.facturier.controller;

import fr.owen.facturier.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/client")
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public String client(Model model) {
        model.addAttribute("clients", clientService.fetchAll());
        return "client/client";
    }
}
