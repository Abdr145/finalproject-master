package com.example.finalproject.service.impl;


import com.example.finalproject.dto.DirectorDto;
import com.example.finalproject.mapper.DirectorMapper;
import com.example.finalproject.model.Director;
import com.example.finalproject.repository.DirectorRepository;
import com.example.finalproject.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public List<DirectorDto> getAll(){
        List<Director> directorEntityList = directorRepository.findAll();
        return directorMapper.toEntityList(directorEntityList);
    }

    @Override
    public DirectorDto getById(Long id){
        return directorMapper.toDto(directorRepository.findById(id).orElse(null));
    }

    @Override
    public DirectorDto addDirector(DirectorDto directorDto){
        Director directorEntity = directorMapper.toEntity(directorDto);
        return directorMapper.toDto(directorRepository.save(directorEntity));
    }

    @Override
    public DirectorDto updateDirector(Long id, DirectorDto directorDto){
        Director updateDirector = directorRepository.findById(id)
                .orElseThrow();
        updateDirector.setName(directorDto.getName());
        updateDirector.setCountry(directorDto.getCountry());
        return directorMapper.toDto(directorRepository.save(updateDirector));
    }

    @Override
    public boolean deleteDirector(Long id){
        directorRepository.deleteById(id);
        Director director = directorRepository.findById(id).orElse(null);
        if (Objects.isNull(director)){
            return true;
        }
        return false;
    }
}

