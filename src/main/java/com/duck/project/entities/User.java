package com.duck.project.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Table(name = "\"user\"")
@NoArgsConstructor
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Credentials credentials;

    @Embedded
    private Profile profile;

    @CreationTimestamp
    private Timestamp joined;

    @ManyToMany
    @JoinTable(
            name = "ducks_found",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "duck_id")
    )
    private List<Duck> ducks;

    private Boolean deleted = false;
}
