package com.example.property_extender.Property;

import com.example.property_extender.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    /*@RequestMapping(method= RequestMethod.GET,value="/properties")
    ResponseEntity<List<Property>> getAllProperties() {
        return new ResponseEntity<>(propertyService.allProperties(), HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST,value="/properties")
    ResponseEntity<HttpStatus> addProperty(@RequestBody Property property) {
        return new ResponseEntity(HttpStatus.CREATED);
    }*/

    @RequestMapping(method= RequestMethod.GET,value="/properties")
    public List<Property> getAllProperties() {
        return propertyService.allProperties();
    }

    @RequestMapping(method= RequestMethod.POST,value="client/{client_id}/property")
    public void addProperty(@PathVariable int client_id, @RequestBody Property property) {
        propertyService.addProperty(client_id,property);
    }


    @RequestMapping(method= RequestMethod.GET,value="/properties/{property_id}")
    public void getPropertyById(@PathVariable int property_id) {
        propertyService.getPropertyById(property_id);
    }

}
