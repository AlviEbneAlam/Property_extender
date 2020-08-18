package com.example.property_extender;

import com.example.property_extender.Client.Client;
import com.example.property_extender.Client.ClientRepository;
import com.example.property_extender.Client.ClientService;
import com.example.property_extender.Property.Property;
import com.example.property_extender.Property.PropertyRepository;
import com.example.property_extender.Property.PropertyService;
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

    /*@Test
    public boolean ReturnsFalseIfPropertyIsNull(){

    }*/

   /* @Test
    public void TestIsSuccessfulIfPropertyIsAdded(){
        Property property=new Property(1,"Moin","15101064L");
        when(propertyRepository.save(property)).thenReturn(property);

        assertThat(propertyService.addProperty(property)).isEqualTo("Moin");
    }

    @Test
    public void TestIsFindingClientsInDatabaseUsingMockito(){
        System.out.println("Finding all customers");
        when(clientRepository.findAll()).thenReturn(new ArrayList<Client>(Arrays.asList(new Client(1,"Alvi",1234567L),new Client(2, "Rafin",14526347L))));
        assertThat(clientService.allClients().size()).isEqualTo(2);
    }

    @Test
    public void TestPassesIfClientIsFoundById(){

        Client client=new Client(1,"alvi",178999L);

        when(clientRepository.findById(1)).thenReturn(Optional.of(client));

        assertThat(clientService.getClientById(1).getName()).isEqualTo(client.getName());
    }*/
}
