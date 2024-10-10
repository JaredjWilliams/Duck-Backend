package com.duck.project.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, CredentialsMapper.class})
public interface UserMapper {
}
