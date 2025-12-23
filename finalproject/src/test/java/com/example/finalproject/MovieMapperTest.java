package com.example.finalproject;


import com.example.finalproject.dto.DirectorDto;
import com.example.finalproject.dto.GenreDto;
import com.example.finalproject.dto.MovieDto;
import com.example.finalproject.mapper.MovieMapper;
import com.example.finalproject.model.Director;
import com.example.finalproject.model.Genre;
import com.example.finalproject.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MovieMapperTest {
    @Autowired
    private MovieMapper movieMapper;

    @Test
    void convertEntityToDtoTest(){
        Director director = new Director(1L, "Magzhan", "Kazakhstan");
        Genre genre = new Genre(1L, "horror");
        Movie entityMovie = new Movie(1L, "film", 2010, 4.5, director, List.of(genre));

        MovieDto dtoMovie = movieMapper.toDto(entityMovie);
        Assertions.assertNotNull(dtoMovie);

        Assertions.assertNotNull(dtoMovie.getId());
        Assertions.assertNotNull(dtoMovie.getTitle());
        Assertions.assertNotNull(dtoMovie.getYear());
        Assertions.assertNotNull(dtoMovie.getRating());
        Assertions.assertNotNull(dtoMovie.getDirector());
        Assertions.assertNotNull(dtoMovie.getGenre());

        Assertions.assertEquals(entityMovie.getId(), dtoMovie.getId());
        Assertions.assertEquals(entityMovie.getTitle(), dtoMovie.getTitle());
        Assertions.assertEquals(entityMovie.getYear(), dtoMovie.getYear());
        Assertions.assertEquals(entityMovie.getRating(), dtoMovie.getRating());
        Assertions.assertEquals(entityMovie.getDirector().getId(), dtoMovie.getDirector().getId());
        Assertions.assertEquals(entityMovie.getDirector().getName(), dtoMovie.getDirector().getName());

        Assertions.assertEquals(entityMovie.getGenre().size(), dtoMovie.getGenre().size());
        Assertions.assertEquals(entityMovie.getGenre().getFirst().getId(), dtoMovie.getGenre().getFirst().getId());
        Assertions.assertEquals(entityMovie.getGenre().getFirst().getName(), dtoMovie.getGenre().getFirst().getName());
    }

    @Test
    void convertDtoToEntityTest(){
        DirectorDto directorDto = new DirectorDto(2L, "Sabyr", "USA");
        GenreDto genreDto = new GenreDto(2L, "comedy");
        MovieDto dtoMovie = new MovieDto();
        dtoMovie.setId(2L);
        dtoMovie.setTitle("movie");
        dtoMovie.setYear(2000);
        dtoMovie.setRating(3.4);
        dtoMovie.setDirector(directorDto);
        dtoMovie.setGenre(List.of(genreDto));

        Movie entityMovie = movieMapper.toEntity(dtoMovie);
        Assertions.assertNotNull(entityMovie);

        Assertions.assertNotNull(dtoMovie.getId());
        Assertions.assertNotNull(dtoMovie.getTitle());
        Assertions.assertNotNull(dtoMovie.getYear());
        Assertions.assertNotNull(dtoMovie.getRating());
        Assertions.assertNotNull(dtoMovie.getDirector());
        Assertions.assertNotNull(dtoMovie.getGenre());

        Assertions.assertEquals(entityMovie.getId(), dtoMovie.getId());
        Assertions.assertEquals(entityMovie.getTitle(), dtoMovie.getTitle());
        Assertions.assertEquals(entityMovie.getYear(), dtoMovie.getYear());
        Assertions.assertEquals(entityMovie.getRating(), dtoMovie.getRating());
        Assertions.assertEquals(entityMovie.getDirector().getId(), dtoMovie.getDirector().getId());
        Assertions.assertEquals(entityMovie.getDirector().getName(), dtoMovie.getDirector().getName());

        Assertions.assertEquals(entityMovie.getGenre().size(), dtoMovie.getGenre().size());
        Assertions.assertEquals(entityMovie.getGenre().getFirst().getId(), dtoMovie.getGenre().getFirst().getId());
        Assertions.assertEquals(entityMovie.getGenre().getFirst().getName(), dtoMovie.getGenre().getFirst().getName());
    }

    @Test
    void convertEntityListToDtoList(){
        List<Movie> entityList = new ArrayList<>();
        entityList.add(new Movie(3L, "qwer1", 1990, 4.2, new Director(3L,"Abai", "Kazakhstan"), List.of(new Genre(3L, "fantsy"))));
        entityList.add(new Movie(4L, "qwer2", 1995, 4.5, new Director(4L,"Abdrakhman", "Portugal"), List.of(new Genre(4L, "comedy"))));
        entityList.add(new Movie(5L, "qwer3", 1998, 4.7, new Director(5L,"Magzhan", "Japan"), List.of(new Genre(5L, "horror"))));

        List<MovieDto> dtoList = movieMapper.toEntityList(entityList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertNotEquals(0, dtoList.size());
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i<entityList.size(); i++){
            Movie entityMovie = entityList.get(i);
            MovieDto dtoMovie = movieMapper.toDto(entityMovie);

            Assertions.assertNotNull(dtoMovie);

            Assertions.assertNotNull(dtoMovie.getId());
            Assertions.assertNotNull(dtoMovie.getTitle());
            Assertions.assertNotNull(dtoMovie.getYear());
            Assertions.assertNotNull(dtoMovie.getRating());
            Assertions.assertNotNull(dtoMovie.getDirector());
            Assertions.assertNotNull(dtoMovie.getGenre());

            Assertions.assertEquals(entityMovie.getId(), dtoMovie.getId());
            Assertions.assertEquals(entityMovie.getTitle(), dtoMovie.getTitle());
            Assertions.assertEquals(entityMovie.getYear(), dtoMovie.getYear());
            Assertions.assertEquals(entityMovie.getRating(), dtoMovie.getRating());
            Assertions.assertEquals(entityMovie.getDirector().getId(), dtoMovie.getDirector().getId());
            Assertions.assertEquals(entityMovie.getDirector().getName(), dtoMovie.getDirector().getName());

            Assertions.assertEquals(entityMovie.getGenre().size(), dtoMovie.getGenre().size());
            Assertions.assertEquals(entityMovie.getGenre().getFirst().getId(), dtoMovie.getGenre().getFirst().getId());
            Assertions.assertEquals(entityMovie.getGenre().getFirst().getName(), dtoMovie.getGenre().getFirst().getName());
        }
    }
}

