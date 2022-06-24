package com.PatitosdeHule.eCommerce.controllers;


import com.PatitosdeHule.eCommerce.DTOs.ClientDTO;
import com.PatitosdeHule.eCommerce.models.Client;
import com.PatitosdeHule.eCommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping("/clients")
    public List<ClientDTO> getAll() {
        return clientService.getClientsDTO();
    }

    @RequestMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return clientService.getClientDTO(id);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/clients")
    public ResponseEntity<Object> register(

            @RequestParam String name, @RequestParam String lastName,
            @RequestParam String email, @RequestParam String password,
            @RequestParam String cellPhone) {


        if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || cellPhone.isEmpty()) {

            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);

        }

        if (clientService.getClientByEmail(email) != null) {

            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);

        }

        Client newClient = new Client(name, lastName, email, passwordEncoder.encode(password), cellPhone);
        clientService.saveClient(newClient);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/clients/current")
    public ClientDTO getCurrentClient(Authentication authentication) {
        Client client = clientService.getClientCurrent(authentication);
        return new ClientDTO(client);
    }
}