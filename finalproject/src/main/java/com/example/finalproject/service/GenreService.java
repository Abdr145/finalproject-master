package com.example.finalproject.service;

import com.example.finalproject.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();
    GenreDto getById(Long id);
    GenreDto addGenre(GenreDto genreDto);
    GenreDto updateGenre(Long id, GenreDto genreDto);
    boolean deleteGenre(Long id);
}
