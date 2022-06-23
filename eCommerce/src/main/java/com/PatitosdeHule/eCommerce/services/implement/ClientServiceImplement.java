package com.PatitosdeHule.eCommerce.services.implement;


import com.PatitosdeHule.eCommerce.models.Client;
import com.PatitosdeHule.eCommerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceImplement {

    @Autowired
    ClientRepository clientRepository;
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}
