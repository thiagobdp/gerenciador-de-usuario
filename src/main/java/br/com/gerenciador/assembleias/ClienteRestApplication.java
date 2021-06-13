package br.com.gerenciador.assembleias;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.gerenciador.assembleias.model.ResultadoValidaUsuarioEnum;

public class ClienteRestApplication {
	
	private static final String USER_VALIDA_CPF = "http://localhost:8080/users/{cpf}";

	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) throws IOException {
		callValidaCPF("190.796.590-45");
		callValidaCPF("19079659045");
		callValidaCPF("191.796.590-45");
		callValidaCPF("19179659045");
	}

	private static void callValidaCPF(String cpf) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, String> param = new HashMap<String, String>();
		param.put("cpf", cpf);		
		
//		HttpEntity<ResultadoValidaUsuarioEnum> entity = new HttpEntity<ResultadoValidaUsuarioEnum>("parameters", headers);
		HttpEntity<ResultadoValidaUsuarioEnum> entity = new HttpEntity<ResultadoValidaUsuarioEnum>(headers);
		
		try {
		ResponseEntity<ResultadoValidaUsuarioEnum> result = restTemplate.exchange(USER_VALIDA_CPF, HttpMethod.GET, entity, ResultadoValidaUsuarioEnum.class, param);
		System.out.println(result.getBody());
		} catch(RestClientException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex);
		}
		
	}

}
