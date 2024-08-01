package com.helloIftekhar.springJwt.service;

import com.helloIftekhar.springJwt.model.Intervenant;
import com.helloIftekhar.springJwt.repository.IntervenantRepository;
import org.springframework.stereotype.Service;

@Service
public class IntervenantService {

    private IntervenantRepository intervenantRepository;

    public Intervenant findById(Long id) {
        return intervenantRepository.findById(id).orElse(null);
    }


}
