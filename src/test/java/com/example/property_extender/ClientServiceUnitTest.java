package com.example.property_extender;


import com.example.property_extender.Model.Client;
import com.example.property_extender.Repository.ClientRepository;
import com.example.property_extender.Service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
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
        Client client=new Client(1,"Alvi",15101062L,"random",
                167863L,168893L,"random",
                "random","random","random","random");

        when(clientRepository.save(client)).thenReturn(client);

        assertThat(clientService.addClient(client)).isEqualTo("Alvi");
    }

    @Test
    public void TestIsFindingClientsInDatabaseUsingMockito(){
        System.out.println("Finding all customers");
        when(clientRepository.findAll()).thenReturn(new ArrayList<Client>(Arrays.asList(
                new Client(1,"Alvi",15101062L,"random",
                167863L,168893L,"random",
                "random","random","random","random"),

                new Client(1,"Rafin",15101062L,"random",
                        167863L,168893L,"random",
                        "random","random","random","random"))));

        assertThat(clientService.allClients().size()).isEqualTo(2);
    }

    @Test
    public void TestPassesIfClientIsFoundById(){

        Client client=new Client(1,"Alvi",15101062L,"random",
                167863L,168893L,"random",
                "random","random","random","random");

        when(clientRepository.findById(1)).thenReturn(Optional.of(client));

        assertThat(clientService.getClientById(1).getName()).isEqualTo("Alvi");
    }
}

