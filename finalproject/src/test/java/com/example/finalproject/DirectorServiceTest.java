package com.example.finalproject;


import com.example.finalproject.dto.DirectorDto;
import com.example.finalproject.service.DirectorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class DirectorServiceTest {

    @Autowired
    private DirectorService directorService;

    @Test
    void getAllTest(){
        List<DirectorDto> directorDtos = directorService.getAll();
        Assertions.assertNotNull(directorDtos);
        Assertions.assertNotEquals(0, directorDtos.size());

        for (int i = 0; i < directorDtos.size(); i++) {
            DirectorDto directorDto = directorDtos.get(i);
            Assertions.assertNotNull(directorDto);

            Assertions.assertNotNull(directorDto.getId());
            Assertions.assertNotNull(directorDto.getName());
            Assertions.assertNotNull(directorDto.getCountry());
        }
    }

    @Test
    void getByIdTest(){
        Random random = new Random();

        int randomIndex = random.nextInt(directorService.getAll().size());

        Long someId = directorService.getAll().get(randomIndex).getId();

        DirectorDto directorDto = directorService.getById(someId);

        Assertions.assertNotNull(directorDto);

        Assertions.assertNotNull(directorDto.getId());
        Assertions.assertNotNull(directorDto.getName());
        Assertions.assertNotNull(directorDto.getCountry());

        DirectorDto checkDirector = directorService.getById(-1L);
        Assertions.assertNull(checkDirector);

    }

    @Test
    void addDirectorTest(){
        DirectorDto directorDto = new DirectorDto();
        directorDto.setName("Name");
        directorDto.setCountry("USA");

        DirectorDto createdDirector = directorService.addDirector(directorDto);

        Assertions.assertNotNull(createdDirector);

        Assertions.assertNotNull(createdDirector.getId());
        Assertions.assertNotNull(createdDirector.getName());
        Assertions.assertNotNull(directorDto.getCountry());

        Assertions.assertEquals(directorDto.getName(), createdDirector.getName());
        Assertions.assertEquals(directorDto.getCountry(), createdDirector.getCountry());

        DirectorDto getDirector = directorService.getById(createdDirector.getId());

        Assertions.assertNotNull(getDirector);

        Assertions.assertNotNull(getDirector.getId());
        Assertions.assertNotNull(getDirector.getName());
        Assertions.assertNotNull(directorDto.getCountry());

        Assertions.assertEquals(createdDirector.getId(), getDirector.getId());
        Assertions.assertEquals(createdDirector.getName(), getDirector.getName());
        Assertions.assertEquals(createdDirector.getCountry(), getDirector.getCountry());
    }

    @Test
    void updateDirectorTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(directorService.getAll().size());

        Long someId = directorService.getAll().get(randomIndex).getId();

        DirectorDto directorDto = new DirectorDto();
        directorDto.setName("Nolan");
        directorDto.setCountry("USA");


        DirectorDto beforeUpdate = directorService.updateDirector(someId, directorDto);

        Assertions.assertNotNull(beforeUpdate);

        Assertions.assertNotNull(beforeUpdate.getId());
        Assertions.assertNotNull(beforeUpdate.getName());
        Assertions.assertNotNull(beforeUpdate.getCountry());

        Assertions.assertEquals(directorDto.getName(), beforeUpdate.getName());
        Assertions.assertEquals(directorDto.getCountry(), beforeUpdate.getCountry());

        DirectorDto afterUpdate = directorService.getById(someId);

        Assertions.assertNotNull(afterUpdate);

        Assertions.assertNotNull(afterUpdate.getId());
        Assertions.assertNotNull(afterUpdate.getName());
        Assertions.assertNotNull(afterUpdate.getCountry());

        Assertions.assertEquals(beforeUpdate.getId(), afterUpdate.getId());
        Assertions.assertEquals(beforeUpdate.getName(), afterUpdate.getName());
        Assertions.assertEquals(beforeUpdate.getCountry(), afterUpdate.getCountry());
    }

    @Test
    void deleteDirectorTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(directorService.getAll().size());

        Long someId = directorService.getAll().get(randomIndex).getId();
        Assertions.assertTrue(directorService.deleteDirector(someId));
        DirectorDto directorDto = directorService.getById(someId);

        Assertions.assertNull(directorDto);
    }
}

