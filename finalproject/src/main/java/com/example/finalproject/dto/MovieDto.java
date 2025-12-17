package com.example.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Driver;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private Integer year;
    private Double rating;
    private DirectorDto director;
    private List<GenreDto> genre;
}
