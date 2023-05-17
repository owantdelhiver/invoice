package fr.owen.facturier.controller;

import fr.owen.facturier.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("factures")
public class FactureController {
    @Autowired
    FactureService factureService;

    @GetMapping
    public String all(Model model) {
        model.addAttribute("factures", factureService.fetchAll());
        return "factures/factures";
    }
}
