package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Intervenant;
import com.helloIftekhar.springJwt.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IntervenantRepository extends JpaRepository<Intervenant, Long> {

    @Query("SELECT i FROM Intervenant i WHERE i.lvlMin >= :niveau AND i.lvlMax <= :niveau AND i.dispo = 1 ORDER BY i.nbInterventionFaite ASC")
    List<Intervenant> findByNiveauANDisFREE(@Param("niveau") int niveau);

    @Query("SELECT i FROM Intervention i WHERE i.intervenant = :intervenant AND i.date_fin IS NULL AND i.date_deb = (SELECT MAX(i2.date_deb) FROM Intervention i2 WHERE i2.intervenant = :intervenant)")
    List<Intervention> findDerniereIntervention(@Param("intervenant") Intervenant intervenant);
}


