package br.com.gerenciador.usuario.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testValidaCPFValido() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders//
				.get("/users/{cpf}", "41121167721")//
				.contentType(MediaType.APPLICATION_JSON))//
				.andExpect(MockMvcResultMatchers//
						.status()//
						.isOk())
				.andReturn();
		
	}
	
	@Test
	public void testValidaCPFInvalido() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders//
				.get("/users/{cpf}", "141121167721")//
				.contentType(MediaType.APPLICATION_JSON))//
				.andExpect(MockMvcResultMatchers//
						.status()//
						.isNotFound())
				.andReturn();
		
	}

}
