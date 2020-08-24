package com.example.property_extender.Controller;

import com.example.property_extender.Model.Client;
import com.example.property_extender.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping ("/clients")
    public List<Client> getAllClients() {
        return clientService.allClients();
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {

        //Client client1=clientService.addClient(client);

        return new ResponseEntity<Client>(clientService.addClient(client),HttpStatus.CREATED);
        //return new ResponseEntity<>("Adding Successful",HttpStatus.CREATED);
        //return ResponseEntity.accepted().body(client1);
    }

    @GetMapping("/clients/{client_id}")
    public Client getClientById(@PathVariable int client_id) {
        return clientService.getClientById(client_id);
    }



}
