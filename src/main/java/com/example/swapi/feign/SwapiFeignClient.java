package com.example.swapi.feign;

import com.example.swapi.dto.PersonPageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "swapi", url = "https://swapi.dev/api")
public interface SwapiFeignClient {
    @GetMapping("/people/")
    PersonPageDto getPeople(@RequestParam("page") int page);

    @GetMapping("/people/")
    PersonPageDto searchPeople(@RequestParam("search") String name);
}