package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    public Matiere findByName(String name);
}
