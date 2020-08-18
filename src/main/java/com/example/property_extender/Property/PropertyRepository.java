package com.example.property_extender.Property;

import com.example.property_extender.Client.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends MongoRepository<Property, Integer> {

}

