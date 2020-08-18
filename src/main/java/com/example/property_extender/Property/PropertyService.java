package com.example.property_extender.Property;

import com.example.property_extender.Client.Client;
import com.example.property_extender.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public void addProperty(int clientId, Property property){

        propertyRepository.save(property);
        Client client=clientRepository.findById(clientId).get();
        client.getPropertyList().add(property);
        //customerRepository.findById(customerId).get().getOrders().add(order);
        clientRepository.save(client);
    }


    /*public void addProperty(Property property){

        propertyRepository.save(property);
        //customerRepository.findById(customerId).get().getOrders().add(order);
        //clientRepository.save(client);
    }*/

    public List<Property> allProperties(){
        return propertyRepository.findAll();
    }

    public void getPropertyById(int property_id){
        propertyRepository.findById(property_id).get();
    }
}
