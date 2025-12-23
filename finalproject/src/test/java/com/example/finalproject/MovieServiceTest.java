package com.example.finalproject;


import com.example.finalproject.dto.MovieDto;
import com.example.finalproject.service.MovieService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@Transactional
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllTest(){
        List<MovieDto> movieDtos = movieService.getAll();
        Assertions.assertNotNull(movieDtos);
        Assertions.assertNotEquals(0, movieDtos.size());

        for (int i = 0; i < movieDtos.size(); i++) {
            MovieDto movieDto = movieDtos.get(i);
            Assertions.assertNotNull(movieDto);

            Assertions.assertNotNull(movieDto.getId());
            Assertions.assertNotNull(movieDto.getTitle());
            Assertions.assertNotNull(movieDto.getYear());
            Assertions.assertNotNull(movieDto.getRating());
        }
    }

    @Test
    void getByIdTest(){
        Random random = new Random();

        int randomIndex = random.nextInt(movieService.getAll().size());

        Long someId = movieService.getAll().get(randomIndex).getId();

        MovieDto movieDto = movieService.getById(someId);

        Assertions.assertNotNull(movieDto);

        Assertions.assertNotNull(movieDto.getId());
        Assertions.assertNotNull(movieDto.getTitle());
        Assertions.assertNotNull(movieDto.getYear());
        Assertions.assertNotNull(movieDto.getRating());

        MovieDto checkMovie = movieService.getById(-1L);
        Assertions.assertNull(checkMovie);

    }

    @Test
    void addMovieTest(){
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle("Movie");
        movieDto.setYear(2015);
        movieDto.setRating(4.5);

        MovieDto createdMovie = movieService.addMovie(movieDto);

        Assertions.assertNotNull(createdMovie);

        Assertions.assertNotNull(createdMovie.getId());
        Assertions.assertNotNull(createdMovie.getTitle());
        Assertions.assertNotNull(createdMovie.getYear());
        Assertions.assertNotNull(createdMovie.getRating());

        Assertions.assertEquals(movieDto.getTitle(), createdMovie.getTitle());
        Assertions.assertEquals(movieDto.getYear(), createdMovie.getYear());
        Assertions.assertEquals(movieDto.getRating(), createdMovie.getRating());

        MovieDto getMovie = movieService.getById(createdMovie.getId());

        Assertions.assertNotNull(getMovie);

        Assertions.assertNotNull(getMovie.getId());
        Assertions.assertNotNull(getMovie.getTitle());
        Assertions.assertNotNull(getMovie.getYear());
        Assertions.assertNotNull(getMovie.getRating());

        Assertions.assertEquals(createdMovie.getId(), getMovie.getId());
        Assertions.assertEquals(createdMovie.getTitle(), getMovie.getTitle());
        Assertions.assertEquals(createdMovie.getYear(), getMovie.getYear());
        Assertions.assertEquals(createdMovie.getRating(), getMovie.getRating());
    }

    @Test
    void updateMovieTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(movieService.getAll().size());

        Long someId = movieService.getAll().get(randomIndex).getId();

        MovieDto movieDto = new MovieDto();
        movieDto.setTitle("Movie");
        movieDto.setYear(2015);
        movieDto.setRating(4.9);

        MovieDto beforeUpdate = movieService.updateMovie(someId, movieDto);

        Assertions.assertNotNull(beforeUpdate);

        Assertions.assertNotNull(beforeUpdate.getId());
        Assertions.assertNotNull(beforeUpdate.getTitle());
        Assertions.assertNotNull(beforeUpdate.getYear());
        Assertions.assertNotNull(beforeUpdate.getRating());

        Assertions.assertEquals(movieDto.getTitle(), beforeUpdate.getTitle());
        Assertions.assertEquals(movieDto.getYear(), beforeUpdate.getYear());
        Assertions.assertEquals(movieDto.getRating(), beforeUpdate.getRating());

        MovieDto afterUpdate = movieService.getById(someId);

        Assertions.assertNotNull(afterUpdate);

        Assertions.assertNotNull(afterUpdate.getId());
        Assertions.assertNotNull(afterUpdate.getTitle());
        Assertions.assertNotNull(afterUpdate.getYear());
        Assertions.assertNotNull(afterUpdate.getRating());

        Assertions.assertEquals(beforeUpdate.getId(), afterUpdate.getId());
        Assertions.assertEquals(beforeUpdate.getTitle(), afterUpdate.getTitle());
        Assertions.assertEquals(beforeUpdate.getYear(), afterUpdate.getYear());
        Assertions.assertEquals(beforeUpdate.getRating(), afterUpdate.getRating());
    }

    @Test
    void deleteMovieTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(movieService.getAll().size());

        Long someId = movieService.getAll().get(randomIndex).getId();
        Assertions.assertTrue(movieService.deleteMovie(someId));
        MovieDto movieDto = movieService.getById(someId);

        Assertions.assertNull(movieDto);
    }
}
