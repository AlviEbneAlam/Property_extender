package com.example.property_extender;

import ch.qos.logback.core.net.ObjectWriter;
import com.example.property_extender.Client.Client;
import com.example.property_extender.Client.ClientController;
import com.example.property_extender.Client.ClientService;
import com.example.property_extender.Property.Property;
import com.example.property_extender.Property.PropertyController;
import com.example.property_extender.Property.PropertyService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.io.Console;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PropertyController.class)
public class PropertyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PropertyService propertyService;

    /*private static final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private ObjectMapper jsonMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @Test
    void saveProperty() throws Exception{

        Property property=new Property(1,"Alvi","15101063","Attribute");

        //when(clientService.addClient(client)).thenReturn(client);

        mockMvc.perform(MockMvcRequestBuilders.post("/properties")
                .contentType(contentType)
                .content(jsonMapper.writeValueAsString(property))
        )
                .andDo(print())
                .andExpect(status().isCreated());
        //.andExpect(content().contentType(contentType));

    }

    @Test
    void getAllProperties() throws Exception {
        List<Property> allProperties = new ArrayList<>();
        allProperties.add(new Property(1,"Alvi","15101062","Attribute"));
        allProperties.add(new Property(2,"Moin", "15101063","Attribute"));

        when(propertyService.allProperties()).thenReturn(allProperties);

        mockMvc.perform(MockMvcRequestBuilders.get("/properties")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$",hasSize(2))).andDo(print());
    }*/
}
