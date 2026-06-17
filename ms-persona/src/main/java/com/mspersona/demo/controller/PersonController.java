package com.mspersona.demo.controller;


import com.mspersona.demo.model.dto.PersonRequest;
import com.mspersona.demo.model.dto.PersonResponse;
import com.mspersona.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public PersonResponse getPerson(@RequestBody PersonRequest request) {
        return service.getPersonByDocument(request);
    }
}
