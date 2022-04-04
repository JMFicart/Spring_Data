package com.example.hotel.controllers;

import com.example.hotel.exceptions.ElementNotFoundException;
import com.example.hotel.metier.service.GerantService;
import com.example.hotel.models.dtos.ErrorDto;
import com.example.hotel.models.dtos.GerantDto;
import com.example.hotel.models.forms.GerantForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// aiguillage entre requete http et actions à faire

@RestController
public class GerantController {
    public final GerantService service;

    public GerantController(GerantService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/gerant
//    @RequestMapping(method = RequestMethod.GET, path="/gerant")
    @GetMapping("/gerant")
    public List<GerantDto> getAll() {
        return service.getAll();
    }

    // GET - http://localhost:8080/gerant/id
    @GetMapping("/gerant/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOne(@PathVariable(name = "id") Long ident){
        try {
            return ResponseEntity.ok().body(service.getOne(ident));
//            return ResponseEntity.status(HttpStatus.OK).header("from-controller", "GerantController").body(service.getOne(ident));
        }
        catch (ElementNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("header-key","value1", "value2")
                    .body(new ErrorDto(ex.getMessage(),404,"/gerant/"+ ident));
        }
    }

    // POST - http://localhost:8080/gerant
    //      - http://localhost:8080/gerant/add
    @PostMapping({"/gerant", "/gerant/add"})
    public ResponseEntity insert(@RequestBody GerantForm form){
        try {
            return ResponseEntity.ok(service.insert(form));
        }
        catch (IllegalArgumentException ex) {
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorDto(ex.getMessage(), "/gerant/add"));
        }
    }

    // DELETE - http://localhost:8080/gerant
    //        - http://localhost:8080/gerant/delete
    @PostMapping({"/gerant", "/gerant/delete"})
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        try {
            return ResponseEntity.ok(service.delete(id));
        }
        catch (ElementNotFoundException ex) {
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorDto(ex.getMessage(), "/gerant/delete"));
        }
    }

    // PUT - http://localhost:8080/gerant
    //     - http://localhost:8080/gerant/update
    @PostMapping({"/gerant", "/gerant/update"})
    public ResponseEntity update(@PathVariable(name = "id") Long id, @RequestBody GerantForm form){
        try {
            return ResponseEntity.ok(service.update(id, form));
        }
        catch (IllegalArgumentException ex) {
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorDto(ex.getMessage(), "/gerant/update"));
        }
    }
}
