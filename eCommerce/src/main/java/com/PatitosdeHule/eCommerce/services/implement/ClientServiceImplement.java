package com.PatitosdeHule.eCommerce.services.implement;


import com.PatitosdeHule.eCommerce.DTOs.ClientDTO;
import com.PatitosdeHule.eCommerce.models.Client;
import com.PatitosdeHule.eCommerce.repositories.ClientRepository;
import com.PatitosdeHule.eCommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<ClientDTO> getClientsDTO() {
        return clientRepository.findAll().stream().map(client-> new ClientDTO(client)).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientDTO(Long id) {
        return clientRepository.findById(id).map(client -> new ClientDTO(client)).orElse(null);
    }

    @Override
    public Client getClientCurrent(Authentication authentication) {
        return clientRepository.findByEmail(authentication.getName());
    }

    @Override
    public Client getCellPhone(String cellPhone) {
        return null;
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
