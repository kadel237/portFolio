package com.kadel.portfolio.repository;

import com.kadel.portfolio.model.Experience;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface ExperienceRepository extends JpaRepository<Experience, Long> {
        // Pas besoin d'écrire des méthodes pour les CRUD de base, Spring Data JPA les génère automatiquement.
        // Exemple : findAll(), save(), deleteById(), findById(), etc.
    }


