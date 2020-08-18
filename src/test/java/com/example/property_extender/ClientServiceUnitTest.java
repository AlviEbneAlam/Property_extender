package com.example.property_extender;


import com.example.property_extender.Client.Client;
import com.example.property_extender.Client.ClientRepository;
import com.example.property_extender.Client.ClientService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClientServiceUnitTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    //@Disabled("Pre Refractor code")
    @Test
    public void TestIsSuccessfulIfClientIsAdded(){
        Client client=new Client(1,"Moin",15101064L);
        when(clientRepository.save(client)).thenReturn(client);

        assertThat(clientService.addClient(client)).isEqualTo("Moin");
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
    }
}

