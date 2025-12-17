package com.example.finalproject.mapper;

import com.example.finalproject.dto.DirectorDto;
import com.example.finalproject.model.Director;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorDto toDto(Director director);
    Director toEntity(DirectorDto directorDto);
    List<DirectorDto> toEntityList(List<Director> directorEntityList);
}
