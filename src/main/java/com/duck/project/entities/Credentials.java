package com.duck.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Credentials {

//    @Column(unique = true, nullable = false)
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
