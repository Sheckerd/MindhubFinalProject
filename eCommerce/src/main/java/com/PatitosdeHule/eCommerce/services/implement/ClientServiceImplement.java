package com.PatitosdeHule.eCommerce.services.implement;


import com.PatitosdeHule.eCommerce.models.Client;
import com.PatitosdeHule.eCommerce.repositories.ClientRepository;
import com.PatitosdeHule.eCommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}
