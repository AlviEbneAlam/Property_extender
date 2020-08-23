package com.example.property_extender.Repository;

import com.example.property_extender.Model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends MongoRepository<Property, Integer> {

    public List<Property> findPropertyByClientId(String clientId);
}

