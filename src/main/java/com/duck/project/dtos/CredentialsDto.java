package com.duck.project.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CredentialsDto {
    private String username;
    private String password;
}
