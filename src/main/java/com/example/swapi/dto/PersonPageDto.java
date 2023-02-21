package com.example.swapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonPageDto {
    private int count;
    private String next;
    private String previous;
    private List<PersonDto> results;
}
