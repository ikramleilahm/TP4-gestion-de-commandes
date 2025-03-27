package com.example.store.client;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/store")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("/store/home");
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String email, @RequestParam String password,
                                 @RequestParam String nom, @RequestParam String prenom) {
        clientService.register(email, password, nom, prenom);
        ModelAndView modelAndView = new ModelAndView("store/home");
        modelAndView.addObject("email", email);
        modelAndView.addObject("password", password);
        modelAndView.addObject("message","Inscription réussie !");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String password,
                              HttpSession session) {
        Optional<Client> client = clientService.login(email, password);
        ModelAndView modelAndView = new ModelAndView("store/home");

        if (client.isPresent()) {
            session.setAttribute("client", client.get());
            modelAndView.addObject("client", client.get());
            return new ModelAndView("redirect:/store/index");
        } else {
            modelAndView.addObject("error", "email ou mot de passe incorrect");
            return modelAndView;
        }
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/store/home");
    }
}
