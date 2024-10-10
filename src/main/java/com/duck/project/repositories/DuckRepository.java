package com.duck.project.repositories;

import com.duck.project.entities.Duck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuckRepository extends JpaRepository<Duck, Long> {
}
