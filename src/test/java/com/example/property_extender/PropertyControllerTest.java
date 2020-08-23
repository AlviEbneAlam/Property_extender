package com.example.property_extender;

import com.example.property_extender.Controller.PropertyController;
import com.example.property_extender.Model.Property;
import com.example.property_extender.Service.PropertyService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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

    private static final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private ObjectMapper jsonMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @Test
    void saveProperty() throws Exception{

        Property property=new Property(1,"Moin","1256388",
                "bank",10,"random","random",
                168963L,789927L,"random",
                "random","random","random","random");

        when(propertyService.addProperty(property)).thenReturn(property);

        mockMvc.perform(MockMvcRequestBuilders.post("/properties")
                .contentType(contentType)
                .content(jsonMapper.writeValueAsString(property))
        ).andDo(print()).andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Moin"));
        //.andExpect(content().contentType(contentType));

    }

    @Test
    void getAllProperties() throws Exception {
        List<Property> allProperties = new ArrayList<>();

        allProperties.add(
                new Property(1,"Alvi","1256388",
                        "bank",10,"random","random",
                        168963L,789927L,"random",
                        "random","random","random","random"));

        allProperties.add(
                new Property(2,"Moin","1256388",
                        "bank",10,"random","random",
                        168963L,789927L,"random",
                        "random","random","random","random"));

        when(propertyService.allProperties()).thenReturn(allProperties);

        mockMvc.perform(MockMvcRequestBuilders.get("/properties")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$",hasSize(2))).andDo(print());
    }
}
