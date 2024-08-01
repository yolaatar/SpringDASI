package com.helloIftekhar.springJwt.controller;

import com.helloIftekhar.springJwt.dto.InterventionDTO;
import com.helloIftekhar.springJwt.model.Intervention;
import com.helloIftekhar.springJwt.model.User;
import com.helloIftekhar.springJwt.service.InterventionService;
import com.helloIftekhar.springJwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final InterventionService iservice ;
    private final UserService userService ;

    @Autowired
    public UserController(InterventionService iservice, UserService userService) {
        this.iservice = iservice;
        this.userService = userService;
    }

    @GetMapping("/get/name")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) {
        User user = userService.findByUsername(username);
        System.out.println(user);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get/id")
    public ResponseEntity<User> getUserById(@RequestParam Long id) {
        User user = userService.findById(id);
        System.out.println(user);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/submit/intervention")
    public ResponseEntity<String> submitIntervention(@RequestBody InterventionDTO interventionDTO) {
        Intervention intervention = iservice.createIntervention(interventionDTO) ;
        if (intervention != null) {
            return ResponseEntity.ok().body("Intervention created");
        }
        else {
            return ResponseEntity.ok().body("Intervention not created");
        }
    }

}
