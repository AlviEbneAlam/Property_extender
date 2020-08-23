package com.example.property_extender.Controller;

import com.example.property_extender.Model.Property;
import com.example.property_extender.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PropertyController {

    @Autowired
    private PropertyService propertyService;


    @GetMapping("/properties")
    ResponseEntity<List<Property>> getAllProperties() {
        return new ResponseEntity<>(propertyService.allProperties(), HttpStatus.OK);
    }

    @PostMapping("/properties")
    ResponseEntity<Property> addProperty(@RequestBody Property property) {
        return new ResponseEntity(propertyService.addProperty(property),HttpStatus.CREATED);
    }


    @GetMapping("/properties/{property_id}")
    public Property getPropertyByPropertyId(@PathVariable int property_id) {
        return propertyService.getPropertyByPropertyId(property_id);
    }

    @GetMapping("/properties/client/{client_id}")
    public List<Property> getPropertyByClientId(@PathVariable String client_id) {
        return propertyService.findPropertyByClientId(client_id);
    }

}
