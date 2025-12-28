package com.example.finalproject.mapper;

import com.example.finalproject.dto.GenreDto;
import com.example.finalproject.model.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDto toDto(Genre genre);
    Genre toEntity(GenreDto genreDto);
    List<GenreDto> toEntityList(List<Genre> genreEntityList);
}
