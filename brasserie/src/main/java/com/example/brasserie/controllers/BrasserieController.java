package com.example.brasserie.controllers;

import com.example.brasserie.models.Brasserie;
import com.example.brasserie.models.BrasserieForm;
import com.example.brasserie.service.BrasserieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/brasserie")
public class BrasserieController {
    private final BrasserieService service;

    public BrasserieController(BrasserieService service) {
        this.service = service;
    }

    @ModelAttribute("get_all")
    public List<Brasserie> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public String displayOne(@PathVariable int id, Model model){
        Brasserie b = service.getOne(id);
        model.addAttribute("brasserie", b);
        return "pages/displayOne";
    }

    @GetMapping
//    @PreAuthorize("permitAll()")
    public String displayAll(Model model){
        List<Brasserie> list = service.getAll();
        model.addAttribute("brasserie_liste", list);
        return "pages/displayAll";
    }

//    @GetMapping("/bymarque")
////    @PreAuthorize("permitAll()")
//    public String displayMarque(@RequestParam String marque, Model model){
//        model.addAttribute("produit_marque", service.getMarque(marque));
//        model.addAttribute("brand", marque);
//        return "pages/displayMarque";
//    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException ex){
        return "pages/404";
    }

    @GetMapping("/add")
//    @PreAuthorize("isAuthenticated()")
    public String displayInsertForm(@ModelAttribute("brasserie") BrasserieForm form){
        return "templates/pages/forms/BrasserieForm";
    }

    @PostMapping("/add")
//    @PreAuthorize("isAuthenticated()")
    public String processInsert(@Valid @ModelAttribute("brasserie") BrasserieForm form, BindingResult binding){
        if (binding.hasErrors())
            return "templates/pages/forms/BrasserieForm";
        Brasserie rslt = service.insert(form);
        return "redirect:/brasserie/" + rslt.getId();
    }
}
