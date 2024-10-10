package com.duck.project.mappers;


import com.duck.project.dtos.ProfileDto;
import com.duck.project.entities.Profile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile dtoToEntity(ProfileDto profileDto);
    ProfileDto entityToDto(Profile profile);
}
