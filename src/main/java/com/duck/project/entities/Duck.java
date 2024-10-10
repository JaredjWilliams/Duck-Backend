package com.duck.project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Duck {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private Timestamp timestamp;

    @ManyToMany(mappedBy = "ducks")
    private List<User> usersFound;


}
