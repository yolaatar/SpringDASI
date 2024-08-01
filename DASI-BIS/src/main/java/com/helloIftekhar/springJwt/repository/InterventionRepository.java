package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Intervenant;
import com.helloIftekhar.springJwt.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
}
