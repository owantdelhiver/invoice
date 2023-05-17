package fr.owen.facturier.controller;

import fr.owen.facturier.model.produit.Produit;
import fr.owen.facturier.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/produits")
@Controller
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @GetMapping
    public String produit(Model model) {
        model.addAttribute("produits", produitService.fetchAll());
        return "produit/produit";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("produit", new Produit());
        return "produit/add";
    }

    @PostMapping("create")
    public String createPost(@ModelAttribute Produit produit){
        produitService.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable int id) {
        model.addAttribute("produit", produitService.fetchById(id));
        return "produit/edit";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute Produit produit) {
        produitService.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        produitService.delete(id);
        return "redirect:/produits";
    }
}
