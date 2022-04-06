package com.example.hotel.controllers;

import com.example.hotel.exceptions.ElementNotFoundException;
import com.example.hotel.metier.service.GerantService;
import com.example.hotel.models.dtos.ErrorDto;
import com.example.hotel.models.dtos.GerantDto;
import com.example.hotel.models.forms.GerantForm;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
// aiguillage entre requete http et actions à faire

@RestController
@RequestMapping("/gerant")
public class GerantController {
    public final GerantService service;

    public GerantController(GerantService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/gerant
//    @RequestMapping(method = RequestMethod.GET, path="/gerant")
    @GetMapping("")
    public List<GerantDto> getAll() {
        return service.getAll();
    }

    // GET - http://localhost:8080/gerant/id
    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOne(@PathVariable(name = "id") Long ident){
//        try {
            return ResponseEntity.ok().body(service.getOne(ident));
//            return ResponseEntity.status(HttpStatus.OK).header("from-controller", "GerantController").body(service.getOne(ident));
//        }
//        catch (ElementNotFoundException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .header("header-key","value1", "value2")
//                    .body(new ErrorDto(ex.getMessage(),404,"/gerant/"+ ident, HttpMethod.GET));
//        }
    }

    // POST - http://localhost:8080/gerant
    //      - http://localhost:8080/gerant/add
    @PostMapping({"", "/add"})
    public ResponseEntity insert(@Valid @RequestBody GerantForm form){
//        try {
            return ResponseEntity.ok(service.insert(form));
//        }
//        catch (IllegalArgumentException ex) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new ErrorDto(ex.getMessage(), "/gerant/add", HttpMethod.POST));
//        }
    }

    // DELETE - http://localhost:8080/gerant
    //        - http://localhost:8080/gerant/delete
//    @PostMapping({"/gerant", "/gerant/delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
//        try {
            return ResponseEntity.ok(service.delete(id));
//        }
//        catch (ElementNotFoundException ex) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new ErrorDto(ex.getMessage(), "/gerant/delete", HttpMethod.DELETE));
//        }
    }

    // PUT - http://localhost:8080/gerant
    //     - http://localhost:8080/gerant/update
    @PutMapping({"", "/update"})
    public ResponseEntity update(@PathVariable(name = "id") Long ident, @RequestBody GerantForm form){
//        try {
            return ResponseEntity.ok(service.update(ident, form));
//        }
//        catch (IllegalArgumentException ex) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new ErrorDto(ex.getMessage(), "/gerant/update", HttpMethod.PUT));
//        }
//        catch (ElementNotFoundException ex) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new ErrorDto(ex.getMessage(), "/gerant/update", HttpMethod.PUT));
//        }
    }

    @ExceptionHandler()
    public ResponseEntity<ErrorDto> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDto.builder()
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(404)
                                .uri(request.getRequestURI())
                                .build()
                );
    }
}
