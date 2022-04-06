package com.example.hotel.controllers;

import com.example.hotel.exceptions.ElementNotFoundException;
import com.example.hotel.metier.service.HotelService;
import com.example.hotel.models.dtos.ErrorDto;
import com.example.hotel.models.dtos.HotelDto;
import com.example.hotel.models.forms.HotelForm;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    public final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/hotel
    //    @RequestMapping(method = RequestMethod.GET, path="/hotel")
    @GetMapping("")
    public List<HotelDto> getAll() {
        return service.getAll();
    }

    // GET - http://localhost:8080/hotel/id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(name = "id") Long ident){
        return ResponseEntity.ok().body(service.getOne(ident));
    }

    // POST - http://localhost:8080/hotel
    //      - http://localhost:8080/hotel/add
    @PostMapping({"", "/add"})
    public ResponseEntity insert(@RequestBody HotelForm form){
        return ResponseEntity.ok(service.insert(form));
    }

    // DELETE - http://localhost:8080/hotel
    //        - http://localhost:8080/hotel/delete
//    @PostMapping({"/hotel", "/hotel/delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    // PUT - http://localhost:8080/hotel
    //     - http://localhost:8080/hotel/update
    @PutMapping({"", "/update"})
    public ResponseEntity update(@PathVariable(name = "id") Long ident, @RequestBody HotelForm form){
        return ResponseEntity.ok(service.update(ident, form));
    }

}
