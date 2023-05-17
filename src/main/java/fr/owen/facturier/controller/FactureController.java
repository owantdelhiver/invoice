package fr.owen.facturier.controller;

import fr.owen.facturier.model.facture.Facture;
import fr.owen.facturier.model.facture.FactureEdit;
import fr.owen.facturier.service.ClientService;
import fr.owen.facturier.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("factures")
public class FactureController {
    @Autowired
    FactureService factureService;
    @Autowired
    ClientService clientService;

    @GetMapping
    public String all(Model model) {
        model.addAttribute("factures", factureService.fetchAll());
        return "factures/factures";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("facture", new Facture());
        model.addAttribute("clients", clientService.fetchAll());
        return "factures/add";
    }

    @PostMapping("create")
    public String createPost(@ModelAttribute Facture facture) {
        System.out.println("toto");
        return "redirect:/factures";
    }
}