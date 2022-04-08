package com.example.demomvc.controllers;

import com.example.demomvc.models.Produit;
import com.example.demomvc.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/produit")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @ModelAttribute("get_all")
    public List<Produit> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public String displayOne(@PathVariable int id, Model model){
        Produit p = service.getOne(id);
        model.addAttribute("produit", p);
        return "displayOne";
    }

    @GetMapping
    public String displayAll(Model model){
        List<Produit> list = service.getAll();
        model.addAttribute("produit_liste", list);
        return "displayAll";
    }

    @GetMapping("/bymarque")
    public String displayMarque(@RequestParam String marque, Model model){
        model.addAttribute("produit_marque", service.getMarque(marque));
        model.addAttribute("brand", marque);
        return "displayMarque";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException ex){
        return "404";
    }
}
