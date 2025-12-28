package com.example.finalproject;


import com.example.finalproject.dto.DirectorDto;
import com.example.finalproject.mapper.DirectorMapper;
import com.example.finalproject.model.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DirectorMapperTest {
    @Autowired
    private DirectorMapper directorMapper;

    @Test
    void convertEntityToDtoTest(){
        Director entityDirector = new Director(1L, "Magzhan", "Kazakhstan");

        DirectorDto dtoDirector = directorMapper.toDto(entityDirector);
        Assertions.assertNotNull(dtoDirector);

        Assertions.assertNotNull(dtoDirector.getId());
        Assertions.assertNotNull(dtoDirector.getName());
        Assertions.assertNotNull(dtoDirector.getCountry());

        Assertions.assertEquals(entityDirector.getId(), dtoDirector.getId());
        Assertions.assertEquals(entityDirector.getName(), dtoDirector.getName());
        Assertions.assertEquals(entityDirector.getCountry(), dtoDirector.getCountry());
    }

    @Test
    void convertDtoToEntityTest(){
        DirectorDto dtoDirector = new DirectorDto();
        dtoDirector.setId(2L);
        dtoDirector.setName("Abdrakhman");
        dtoDirector.setCountry("USA");

        Director entityDirector = directorMapper.toEntity(dtoDirector);
        Assertions.assertNotNull(entityDirector);

        Assertions.assertNotNull(dtoDirector.getId());
        Assertions.assertNotNull(dtoDirector.getName());
        Assertions.assertNotNull(dtoDirector.getCountry());

        Assertions.assertEquals(entityDirector.getId(), dtoDirector.getId());
        Assertions.assertEquals(entityDirector.getName(), dtoDirector.getName());
        Assertions.assertEquals(entityDirector.getCountry(), dtoDirector.getCountry());
    }

    @Test
    void convertEntityListToDtoList(){
        List<Director> entityList = new ArrayList<>();
        entityList.add(new Director(3L,"Miko", "USA"));
        entityList.add(new Director(4L,"Abdrakhman", "Kazakhstan"));
        entityList.add(new Director(5L,"Magzhan", "Japan"));

        List<DirectorDto> dtoList = directorMapper.toEntityList(entityList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertNotEquals(0, dtoList.size());
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i<entityList.size(); i++){
            Director entityDirector = entityList.get(i);
            DirectorDto dtoDirector = directorMapper.toDto(entityDirector);

            Assertions.assertNotNull(dtoDirector);
            Assertions.assertNotNull(dtoDirector.getId());
            Assertions.assertNotNull(dtoDirector.getName());
            Assertions.assertNotNull(dtoDirector.getCountry());

            Assertions.assertEquals(entityDirector.getId(), dtoDirector.getId());
            Assertions.assertEquals(entityDirector.getName(), dtoDirector.getName());
            Assertions.assertEquals(entityDirector.getCountry(), dtoDirector.getCountry());
        }
    }
}
