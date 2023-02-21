package com.example.swapi.service;

import com.example.swapi.dto.PersonDto;
import com.example.swapi.dto.PersonPageDto;
import com.example.swapi.feign.SwapiFeignClient;
import com.example.swapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private SwapiFeignClient feignClient;

    public List<Person> getPeople(int page) {
        PersonPageDto personPage = feignClient.getPeople(page);
        return personPage.getResults().stream()
                .map(this::mapToPerson)
                .collect(Collectors.toList());
    }

    public List<Person> searchPeople(String name) {
        PersonPageDto personPage = feignClient.searchPeople(name);
        return personPage.getResults().stream()
                .filter(personDto -> personDto.getName().toLowerCase().contains(name.toLowerCase()))
                .map(this::mapToPerson)
                .collect(Collectors.toList());
    }

    private Person mapToPerson(PersonDto personDto) {
        return new Person(
                personDto.getName(),
                personDto.getHeight(),
                personDto.getMass(),
                personDto.getGender(),
                personDto.getHomeworld()
        );
    }
}
