package com.example.finalproject.service;

import com.example.finalproject.dto.DirectorDto;

import java.util.List;

public interface DirectorService {
    List<DirectorDto> getAll();
    DirectorDto getById(Long id);
    DirectorDto addDirector(DirectorDto directorDto);
    DirectorDto updateDirector(Long id, DirectorDto directorDto);
    boolean deleteDirector(Long id);
}
