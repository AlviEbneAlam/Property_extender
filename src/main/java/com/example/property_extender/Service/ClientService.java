package com.example.property_extender.Service;

import com.example.property_extender.Model.Client;
import com.example.property_extender.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;



    public Client addClient(Client client){

        return clientRepository.save(client);

    }


    public List<Client> allClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(int id){
        return clientRepository.findById(id).get();
    }

}
