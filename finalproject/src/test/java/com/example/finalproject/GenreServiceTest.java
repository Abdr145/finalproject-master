package com.example.finalproject;


import com.example.finalproject.dto.GenreDto;
import com.example.finalproject.service.GenreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class GenreServiceTest {

    @Autowired
    private GenreService genreService;

    @Test
    void getAllTest(){
        List<GenreDto> genreDtos = genreService.getAll();
        Assertions.assertNotNull(genreDtos);
        Assertions.assertNotEquals(0, genreDtos.size());

        for (int i = 0; i < genreDtos.size(); i++) {
            GenreDto genreDto = genreDtos.get(i);
            Assertions.assertNotNull(genreDto);

            Assertions.assertNotNull(genreDto.getId());
            Assertions.assertNotNull(genreDto.getName());
        }
    }

    @Test
    void getByIdTest(){
        Random random = new Random();

        int randomIndex = random.nextInt(genreService.getAll().size());

        Long someId = genreService.getAll().get(randomIndex).getId();

        GenreDto genreDto = genreService.getById(someId);

        Assertions.assertNotNull(genreDto);

        Assertions.assertNotNull(genreDto.getId());
        Assertions.assertNotNull(genreDto.getName());

        GenreDto checkGenre = genreService.getById(-1L);
        Assertions.assertNull(checkGenre);

    }

    @Test
    void addGenreTest(){
        GenreDto genreDto = new GenreDto();
        genreDto.setName("comedy");

        GenreDto createdGenre = genreService.addGenre(genreDto);

        Assertions.assertNotNull(createdGenre);

        Assertions.assertNotNull(createdGenre.getId());
        Assertions.assertNotNull(createdGenre.getName());

        Assertions.assertEquals(genreDto.getName(), createdGenre.getName());

        GenreDto getGenre = genreService.getById(createdGenre.getId());

        Assertions.assertNotNull(getGenre);

        Assertions.assertNotNull(getGenre.getId());
        Assertions.assertNotNull(getGenre.getName());

        Assertions.assertEquals(createdGenre.getId(), getGenre.getId());
        Assertions.assertEquals(createdGenre.getName(), getGenre.getName());
    }

    @Test
    void updateGenreTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(genreService.getAll().size());

        Long someId = genreService.getAll().get(randomIndex).getId();

        GenreDto genreDto = new GenreDto();
        genreDto.setName("horror");


        GenreDto beforeUpdate = genreService.updateGenre(someId, genreDto);

        Assertions.assertNotNull(beforeUpdate);

        Assertions.assertNotNull(beforeUpdate.getId());
        Assertions.assertNotNull(beforeUpdate.getName());

        Assertions.assertEquals(genreDto.getName(), beforeUpdate.getName());

        GenreDto afterUpdate = genreService.getById(someId);

        Assertions.assertNotNull(afterUpdate);

        Assertions.assertNotNull(afterUpdate.getId());
        Assertions.assertNotNull(afterUpdate.getName());

        Assertions.assertEquals(beforeUpdate.getId(), afterUpdate.getId());
        Assertions.assertEquals(beforeUpdate.getName(), afterUpdate.getName());
    }

    @Test
    void deleteGenreTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(genreService.getAll().size());

        Long someId = genreService.getAll().get(randomIndex).getId();
        Assertions.assertTrue(genreService.deleteGenre(someId));
        GenreDto genreDto = genreService.getById(someId);

        Assertions.assertNull(genreDto);
    }
}

