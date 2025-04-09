package com.example.store.kafka;


import com.example.store.Article.Article;
import com.example.store.Article.ArticleService;
import com.example.store.Commande.Commande;
import com.example.store.Commande.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private ArticleService articleService;

    @PostMapping("/commande/{id}")
    public ModelAndView validerEtSupprimerCommande(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Commande commande = commandeService.findById(id);
        if (commande != null) {
            for (Article article : commande.getArticles()) {
                String message = article.getLibelle() + " " + article.getQuantite();
                kafkaProducer.produce(message);
            }
            commandeService.delete(id);
        } else {
            System.out.println("Commande non trouvée pour l'id : " + id);
        }
        modelAndView.setViewName("redirect:/store/article");

        return modelAndView;


    }



}
