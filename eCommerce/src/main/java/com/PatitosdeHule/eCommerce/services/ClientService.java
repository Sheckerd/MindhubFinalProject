package com.PatitosdeHule.eCommerce.services;

import com.PatitosdeHule.eCommerce.DTOs.ClientDTO;
import com.PatitosdeHule.eCommerce.models.Client;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getClientsDTO();

    ClientDTO getClientDTO(Long id);

    Client getClientCurrent(Authentication authentication);

    Client getCellPhone(String cellPhone);

    Client getClientByEmail(String email);

    void saveClient(Client client);

}
