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


        if (name.isEmpty()) {

            return new ResponseEntity<>("Missing data: name is empty", HttpStatus.FORBIDDEN);

        }

        if (lastName.isEmpty()) {

                    return new ResponseEntity<>("Missing data: last name is empty", HttpStatus.FORBIDDEN);

        }

        if (email.isEmpty()) {

                    return new ResponseEntity<>("Missing data: email is empty", HttpStatus.FORBIDDEN);

        }

        if (password.isEmpty()) {

                    return new ResponseEntity<>("Missing data: password is empty", HttpStatus.FORBIDDEN);

        }

        if (cellPhone.isEmpty()) {

                     return new ResponseEntity<>("Missing data: cell phone is empty", HttpStatus.FORBIDDEN);

        }


        if (clientService.getClientByEmail(email) != null) {

            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);

        }

        if(!email.contains("@") || !email.contains(".com")){

                    return new ResponseEntity<>("The email is not valid", HttpStatus.FORBIDDEN);
                }

        if (password.length() < 6) {

            return new ResponseEntity<>("Password to short: At least 6 characters", HttpStatus.FORBIDDEN);

        }

        if (password.length() > 15) {

            return new ResponseEntity<>("Password to long: cannot be longer than 15 characters", HttpStatus.FORBIDDEN);

        }


        Client newClient = new Client(name, lastName, email, passwordEncoder.encode(password), cellPhone, false);
        clientService.saveClient(newClient);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/clients/current")
    public ClientDTO getCurrentClient(Authentication authentication) {
        Client client = clientService.getClientCurrent(authentication);
        return new ClientDTO(client);
    }

    @PatchMapping("/clients/subscription")
    public ResponseEntity<Object> clientChangePremium(Authentication authentication) {

        Client client = clientService.getClientCurrent(authentication);

        if (client.isPremium()) {

            return new ResponseEntity<>("The client is already premium", HttpStatus.FORBIDDEN);
        }

        if (client.getEmail().contains("@orgm.com")) {

            return new ResponseEntity<>("Administrators can't adquire premium status", HttpStatus.FORBIDDEN);
        }


        client.setPremium(true);
        clientService.saveClient(client);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @PatchMapping("/clients/unsubscribe")
    public ResponseEntity<Object> clientChangeCommon(Authentication authentication) {

        Client client = clientService.getClientCurrent(authentication);

        if (!client.isPremium()) {

            return new ResponseEntity<>("The client status is common", HttpStatus.FORBIDDEN);
        }

        if (client.getEmail().contains("@orgm.com")) {

            return new ResponseEntity<>("Administrators can't adquire common status", HttpStatus.FORBIDDEN);
        }


        client.setPremium(false);
        clientService.saveClient(client);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


}