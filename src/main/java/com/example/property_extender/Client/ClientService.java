package com.example.property_extender.Client;

import com.example.property_extender.Property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;



    /*public String addClient(Client client){
        return clientRepository.save(client).getName();

    }*/

    public void addClient(Client client){
        clientRepository.save(client);
        client.setPropertyList(new ArrayList<>(Arrays.asList(new Property(1,"Moin","1256388"))));
        clientRepository.save(client);
    }


    public List<Client> allClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(int client_id) {
        return clientRepository.findById(client_id).get();
    }
}
