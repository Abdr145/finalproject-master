package com.example.finalproject.service.impl;

import com.example.finalproject.dto.GenreDto;
import com.example.finalproject.mapper.GenreMapper;
import com.example.finalproject.model.Genre;
import com.example.finalproject.repository.GenreRepository;
import com.example.finalproject.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAll(){
        List<Genre> genreEntityList = genreRepository.findAll();
        return genreMapper.toEntityList(genreEntityList);
    }

    @Override
    public GenreDto getById(Long id){
        return genreMapper.toDto(genreRepository.findById(id).orElse(null));
    }

    @Override
    public GenreDto addGenre(GenreDto genreDto){
        Genre genreEntity = genreMapper.toEntity(genreDto);
        return genreMapper.toDto(genreRepository.save(genreEntity));
    }

    @Override
    public GenreDto updateGenre(Long id, GenreDto genreDto){
        Genre updateGenre = genreRepository.findById(id)
                .orElse(null);
        updateGenre.setName(genreDto.getName());
        return genreMapper.toDto(genreRepository.save(updateGenre));
    }

    @Override
    public boolean deleteGenre(Long id){
        genreRepository.deleteById(id);
        Genre genre = genreRepository.findById(id).orElse(null);
        if (Objects.isNull(genre)){
            return true;
        }
        return false;
    }
}

