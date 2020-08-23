package com.example.property_extender;

import com.example.property_extender.Repository.ClientRepository;
import com.example.property_extender.Model.Property;
import com.example.property_extender.Repository.PropertyRepository;
import com.example.property_extender.Service.PropertyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PropertyServiceUnitTest {

    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private ClientRepository clientRepository;

    /*@Test
    public boolean ReturnsFalseIfPropertyIsNull(){

    }*/

    @Test
    public void TestIsSuccessfulIfPropertyIsAdded(){
        Property property=new Property(
                1,"Moin","1256388",
                "bank",10,"random","random",
                168963L,789927L,"random",
                "random","random","random","random");


        when(propertyRepository.save(property)).thenReturn(property);


        assertThat(propertyService.addProperty(property).getName()).isEqualTo("Moin");
    }

    @Test
    public void TestIsFindingClientsInDatabaseUsingMockito(){
        System.out.println("Finding all customers");
        when(propertyRepository.findAll()).thenReturn(new ArrayList<Property>(Arrays.asList(

                new Property(1,"Moin","1256388",
                        "bank",10,"random","random",
                        168963L,789927L,"random",
                        "random","random","random","random"),

                new Property(2,"Alvi","1256388",
                        "bank",10,"random","random",
                        168963L,789927L,"random",
                        "random","random","random","random")
        )));




        assertThat(propertyService.allProperties().size()).isEqualTo(2);
    }

    @Test
    public void TestPassesIfPropertyIsFoundByPropertyId(){

        Property property=new Property(2,"Alvi","1256388",
                "bank",10,"random","random",
                168963L,789927L,"random",
                "random","random","random","random");


        when(propertyRepository.findById(1)).thenReturn(Optional.of(property));

        assertThat(propertyService.getPropertyByPropertyId(1).getName()).isEqualTo("Alvi");
    }

    @Test
    public void TestPassesIfPropertyIsFoundByClientId(){

        Property property=new Property(2,"Alvi","1256388",
                "bank",10,"176839","random",
                168963L,789927L,"random",
                "random","random","random","random");


        when(propertyRepository.findPropertyByClientId("1")).thenReturn(property);

        assertThat(propertyService.findPropertyByClientId("1").getName()).isEqualTo("Alvi");
    }

}
