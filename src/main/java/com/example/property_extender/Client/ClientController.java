package com.example.property_extender.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClientController {

    @Autowired
    private ClientService clientService;


    /*@RequestMapping(method= RequestMethod.POST,value="/clients")
    ResponseEntity<HttpStatus> addClient(@RequestBody Client client) {
        return new ResponseEntity(HttpStatus.CREATED);
    }
*/
    @GetMapping ("/clients")
    public List<Client> getAllClients() {
        return clientService.allClients();
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {

        return new ResponseEntity<>(client,HttpStatus.CREATED);

    }



}
