package com.example.property_extender.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    /*@RequestMapping(method= RequestMethod.GET,value="/clients")
    ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.allClients(), HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST,value="/clients")
    ResponseEntity<HttpStatus> addClient(@RequestBody Client client) {
        return new ResponseEntity(HttpStatus.CREATED);
    }*/

    @RequestMapping(method= RequestMethod.GET,value="/clients")
    public List<Client> getAllClients() {
        return clientService.allClients();
    }

    @RequestMapping(method= RequestMethod.POST,value="/clients")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @RequestMapping(method= RequestMethod.GET,value="/clients/{client_id}")
    public Client getClientById(@PathVariable int client_id) {
        return clientService.getClientById(client_id);
    }


}
