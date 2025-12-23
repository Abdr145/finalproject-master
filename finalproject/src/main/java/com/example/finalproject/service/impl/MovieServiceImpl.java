package com.example.finalproject.service.impl;

import com.example.finalproject.dto.MovieDto;
import com.example.finalproject.mapper.MovieMapper;
import com.example.finalproject.model.Movie;
import com.example.finalproject.repository.MovieRepository;
import com.example.finalproject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    @Override
    public List<MovieDto> getAll(){
        List<Movie> movieEntityList = movieRepository.findAll();
        return movieMapper.toEntityList(movieEntityList);
    }
    @Override
    public MovieDto getById(Long id){
        return movieMapper.toDto(movieRepository.findById(id).orElse(null));
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto){
        Movie movieEntity = movieMapper.toEntity(movieDto);
        return movieMapper.toDto(movieRepository.save(movieEntity));
    }
    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto){
        Movie updateMovie = movieRepository.findById(id)
                .orElse(null);
        Movie movieEntity = movieMapper.toEntity(movieDto);
        updateMovie.setTitle(movieDto.getTitle());
        updateMovie.setYear(movieDto.getYear());
        updateMovie.setRating(movieDto.getRating());
        updateMovie.setDirector(movieEntity.getDirector());
        updateMovie.setGenre(movieEntity.getGenre());
        return movieMapper.toDto(movieRepository.save(updateMovie));
    }
    @Override
    public boolean deleteMovie(Long id){
        movieRepository.deleteById(id);
        Movie movie = movieRepository.findById(id).orElse(null);

        if (Objects.isNull(movie)){
            return true;
        }
        return false;
    }
}

