package br.com.gerenciador.assembleias.controller;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void accreditationTest() throws Exception {
		URI uri = new URI("/user/accreditation");

		//json to upload documents and accreditate user
		String json = "{\r\n"//
				+ "    \"user_id\": \"g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V\",\r\n"//
				+ "    \"payload\": {\r\n"//
				+ "        \"accreditation_type\": \"BY_INCOME\",\r\n"//
				+ "        \"documents\": [\r\n"//
				+ "            {\r\n"//
				+ "                \"name\": \"2018.pdf\",\r\n"//
				+ "                \"mime_type\": \"application/pdf\",\r\n"//
				+ "                \"content\": \"ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==\"\r\n"//
				+ "            },\r\n"//
				+ "            {\r\n"//
				+ "                \"name\": \"2019.jpg\",\r\n"//
				+ "                \"mime_type\": \"image/jpeg\",\r\n"//
				+ "                \"content\": \"91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo=\"\r\n"//
				+ "            }\r\n"//
				+ "        ]\r\n"//
				+ "    }\r\n"//
				+ "}";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders//
				.post(uri)//
				.content(json)//
				.contentType(MediaType.APPLICATION_JSON))//
				.andExpect(MockMvcResultMatchers//
						.status()//
						.isOk())
				.andReturn();

		String jsonReturned = mvcResult.getResponse().getContentAsString();
		String jsonExpectedSuccessTrue = "\"success\":true";
		String jsonExpectedAccreditedTrue = "\"accredited\":true";
		String jsonExpectedAccreditedFalse = "\"accredited\":false";

		Assert.assertTrue(jsonReturned.contains(jsonExpectedSuccessTrue));

		Assert.assertTrue(jsonReturned.contains(jsonExpectedAccreditedTrue)
				|| jsonReturned.contains(jsonExpectedAccreditedFalse));
	}

}
