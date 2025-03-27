package com.example.store.Commande;

import com.example.store.client.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/store")
public class CommandeController {
    @Autowired
    private CommandeService service;

    @GetMapping("/index")
    public ModelAndView index(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("store/index");
        Client client = (Client) session.getAttribute("client");

        if (client == null) {
            modelAndView.setViewName("redirect:/store/home");
            return modelAndView;
        }

        List<Commande> commandes = service.findByClient(client);
        modelAndView.addObject("commandes", commandes);
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @PostMapping("/commande/create")
    public ModelAndView create(@RequestParam String nom_comm, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("redirect:/store/index");
        Client client = (Client) session.getAttribute("client");

        if (client != null) {
            service.create(nom_comm, client, List.of());
        }
        return modelAndView;
    }


}
