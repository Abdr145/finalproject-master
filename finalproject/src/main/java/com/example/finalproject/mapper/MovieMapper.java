package com.example.finalproject.mapper;

import com.example.finalproject.dto.MovieDto;
import com.example.finalproject.model.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, DirectorMapper.class})
public interface MovieMapper {
    MovieDto toDto(Movie movie);
    Movie toEntity(MovieDto movieDto);
    List<MovieDto> toEntityList(List<Movie> movieEntityList);
}
