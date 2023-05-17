package fr.owen.facturier.controller;

import fr.owen.facturier.model.client.Client;
import fr.owen.facturier.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clients")
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public String client(Model model) {
        model.addAttribute("clients", clientService.fetchAll());
        return "client/client";
    }

    @GetMapping("create")
    public String createGet(Model model) {
        model.addAttribute("client", new Client());
        return "client/add";
    }

    @PostMapping("create")
    public String createPost(@ModelAttribute Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("edit/{id}")
    public String editGet(Model model, @PathVariable int id) {
        model.addAttribute("client", clientService.fetchById(id));
        return "client/edit";
    }

    @PostMapping("edit/{id}")
    public String editPost(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
