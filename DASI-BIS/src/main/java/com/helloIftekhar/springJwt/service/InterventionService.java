package com.helloIftekhar.springJwt.service;

import com.helloIftekhar.springJwt.dto.InterventionDTO;
import com.helloIftekhar.springJwt.model.Intervenant;
import com.helloIftekhar.springJwt.model.Intervention;
import com.helloIftekhar.springJwt.model.Matiere;
import com.helloIftekhar.springJwt.model.User;
import com.helloIftekhar.springJwt.repository.IntervenantRepository;
import com.helloIftekhar.springJwt.repository.InterventionRepository;
import com.helloIftekhar.springJwt.repository.MatiereRepository;
import com.helloIftekhar.springJwt.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class InterventionService {

    public InterventionRepository repository ;

    public IntervenantRepository i_repository ;

    public MatiereRepository m_repository ;

    public UserRepository user_repository ;

    public Intervention findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Intervention createIntervention(InterventionDTO interventionDTO) {
        Intervention intervention = new Intervention() ;
        User user = new User() ;
        try {

            user = user_repository.findByUsername(interventionDTO.getUsername()).orElseThrow();
            List<Intervenant> intervenants = new ArrayList<Intervenant>();
            intervenants = i_repository.findByNiveauANDisFREE(user.getLevel());
            Intervenant intervenant = new Intervenant() ;
            intervenant = intervenants.isEmpty() ? null : intervenants.get(0);

            Matiere matiere = m_repository.findByName(interventionDTO.getMatiere()) ;
            intervention.setMatiere(matiere);
            intervention.setUser(user);
            intervention.setDetails(interventionDTO.getDetails());
            if (intervenant != null) {
                Date now = new Date(System.currentTimeMillis());
                intervention.setDate_deb(now);
                intervention.setIntervenant(intervenant);
                repository.save(intervention);

                intervenant.setNbInterventionFaite(intervenant.getNbInterventionFaite() + 1);
                intervenant.setDispo(0);
                i_repository.save(intervenant);
            }
        } catch(Exception e) {
            e.printStackTrace();
            intervention = null ;
        }

        return intervention ;
    }

    @Transactional
    public boolean sendBilan(Long intervention_id, String bilan) {
        Boolean sucess ;
        Intervention intervention ;
        try {
            intervention = repository.findById(intervention_id).orElseThrow() ;
            intervention.setBilan(bilan);
            intervention.setDate_fin(new Date(System.currentTimeMillis()));
            repository.save(intervention);

            Intervenant intervenant = intervention.getIntervenant();
            intervenant.setDispo(1);
            i_repository.save(intervenant);
            sucess = true;
        } catch(Exception e) {
            sucess = false;
            e.printStackTrace();
        }

        return sucess;
    }

    @Transactional
    public boolean sendNote(Long intervention_id, int note) {
        Boolean success ;
        Intervention intervention ;
        try {
            intervention = repository.findById(intervention_id).orElseThrow() ;
            intervention.setNote(note);
            repository.save(intervention);
            success = true ;
        } catch(Exception e) {
            success = false;
            e.printStackTrace();
        }

        return success;
    }

    public Intervention getCurrentIntervention(Intervenant intervenant) {
        Intervention intervention = null ;
        return i_repository.findDerniereIntervention(intervenant).isEmpty() ? null : i_repository.findDerniereIntervention(intervenant).get(0);
}

}
