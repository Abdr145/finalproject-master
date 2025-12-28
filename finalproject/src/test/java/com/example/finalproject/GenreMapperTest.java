package com.example.finalproject;


import com.example.finalproject.dto.GenreDto;
import com.example.finalproject.mapper.GenreMapper;
import com.example.finalproject.model.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GenreMapperTest {
    @Autowired
    private GenreMapper genreMapper;

    @Test
    void convertEntityToDtoTest(){
        Genre entityGenre = new Genre(1L, "horror");

        GenreDto dtoGenre = genreMapper.toDto(entityGenre);
        Assertions.assertNotNull(dtoGenre);

        Assertions.assertNotNull(dtoGenre.getId());
        Assertions.assertNotNull(dtoGenre.getName());

        Assertions.assertEquals(entityGenre.getId(), dtoGenre.getId());
        Assertions.assertEquals(entityGenre.getName(), dtoGenre.getName());
    }

    @Test
    void convertDtoToEntityTest(){
        GenreDto dtoGenre = new GenreDto();
        dtoGenre.setId(2L);
        dtoGenre.setName("comedy");


        Genre entityGenre = genreMapper.toEntity(dtoGenre);
        Assertions.assertNotNull(entityGenre);

        Assertions.assertNotNull(dtoGenre.getId());
        Assertions.assertNotNull(dtoGenre.getName());

        Assertions.assertEquals(entityGenre.getId(), dtoGenre.getId());
        Assertions.assertEquals(entityGenre.getName(), dtoGenre.getName());
    }

    @Test
    void convertEntityListToDtoList(){
        List<Genre> entityList = new ArrayList<>();
        entityList.add(new Genre(3L, "fantsy"));
        entityList.add(new Genre(4L, "comedy"));
        entityList.add(new Genre(5L, "horror"));

        List<GenreDto> dtoList = genreMapper.toEntityList(entityList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertNotEquals(0, dtoList.size());
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i<entityList.size(); i++){
            Genre entityGenre = entityList.get(i);
            GenreDto dtoGenre = genreMapper.toDto(entityGenre);

            Assertions.assertNotNull(dtoGenre);

            Assertions.assertNotNull(dtoGenre.getId());
            Assertions.assertNotNull(dtoGenre.getName());

            Assertions.assertEquals(entityGenre.getId(), dtoGenre.getId());
            Assertions.assertEquals(entityGenre.getName(), dtoGenre.getName());
        }
    }
}
