package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

    public Etablissement findByUai(String Uai);
}
