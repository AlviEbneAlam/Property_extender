package com.example.property_extender;

import ch.qos.logback.core.net.ObjectWriter;
import com.example.property_extender.Client.Client;
import com.example.property_extender.Client.ClientController;
import com.example.property_extender.Client.ClientService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
@WebMvcTest(ClientController.class)
class ClientControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private ClientService clientService;

	/*@InjectMocks
	private ClientController clientController;*/

	private static final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));
	private ObjectMapper jsonMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);


	//test case to get all clients
	@Test
	void TestPassesIfGetReturnsTwoClients() throws Exception {
		List<Client> allClients = new ArrayList<>();
		allClients.add(new Client(1,"Alvi",15101062L));
		allClients.add(new Client(2,"Moin", 15101063L));

		when(clientService.allClients()).thenReturn(allClients);

		mockMvc.perform(MockMvcRequestBuilders.get("/clients")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(jsonPath("$",hasSize(2))).andDo(print());
	}

	@Test
	void TestPassesIfStatusIsCreated() throws Exception{

		Client client=new Client(1,"Alvi",15101062L);

		//when(clientService.addClient(client)).thenReturn("Test Successful");

		mockMvc.perform(MockMvcRequestBuilders.post("/clients")
				.contentType(contentType)
				.content(jsonMapper.writeValueAsString(client))
		).andDo(print()).andExpect(content().string("Adding Successful"));
				//.andExpect(content().contentType(contentType));

	}



}
