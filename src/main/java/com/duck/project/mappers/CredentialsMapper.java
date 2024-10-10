package com.duck.project.mappers;


import com.duck.project.dtos.CredentialsDto;
import com.duck.project.entities.Credentials;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
    Credentials dtoToEntity(CredentialsDto credentialsDto);
    CredentialsDto entityToDto(Credentials credentials);
}
