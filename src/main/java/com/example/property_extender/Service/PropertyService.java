package com.example.property_extender.Service;

import com.example.property_extender.Repository.ClientRepository;
import com.example.property_extender.Model.Property;
import com.example.property_extender.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Property addProperty(Property property){

        return propertyRepository.save(property);

    }



    public List<Property> allProperties(){
        return propertyRepository.findAll();
    }

    public Property getPropertyByPropertyId(int property_id){
     return propertyRepository.findById(property_id).get();
 }

    public Property findPropertyByClientId(String client_id){
        return propertyRepository.findPropertyByClientId(client_id);
    }
}
