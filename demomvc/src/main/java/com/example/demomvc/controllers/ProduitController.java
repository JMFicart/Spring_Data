package com.example.demomvc.controllers;

import com.example.demomvc.models.Produit;
import com.example.demomvc.models.ProduitForm;
import com.example.demomvc.service.ProduitService;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return "pages/displayOne";
    }

    @GetMapping
//    @PreAuthorize("permitAll()")
    public String displayAll(Model model){
        List<Produit> list = service.getAll();
        model.addAttribute("produit_liste", list);
        return "pages/displayAll";
    }

    @GetMapping("/bymarque")
//    @PreAuthorize("permitAll()")
    public String displayMarque(@RequestParam String marque, Model model){
        model.addAttribute("produit_marque", service.getMarque(marque));
        model.addAttribute("brand", marque);
        return "pages/displayMarque";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException ex){
        return "pages/404";
    }

    @GetMapping("/add")
//    @PreAuthorize("isAuthenticated()")
    public String displayInsertForm(@ModelAttribute("produit")ProduitForm form){
        return "forms/produitForm";
    }

    @PostMapping("/add")
//    @PreAuthorize("isAuthenticated()")
    public String processInsert(@Valid @ModelAttribute("produit")ProduitForm form, BindingResult binding){
        if (binding.hasErrors())
            return "forms/ProduitForm";
        Produit rslt = service.insert(form);
        return "redirect:/produit/" + rslt.getId();
    }
}
