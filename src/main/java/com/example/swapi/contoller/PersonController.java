package com.example.swapi.controller;

import com.example.swapi.model.Person;
import com.example.swapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public List<Person> getPeople(@RequestParam(value = "page", defaultValue = "1") int page) {
        return personService.getPeople(page);
    }

    @GetMapping("/person/{name}")
    public List<Person> searchPeople(@PathVariable("name") String name) {
        return personService.searchPeople(name);
    }
}
