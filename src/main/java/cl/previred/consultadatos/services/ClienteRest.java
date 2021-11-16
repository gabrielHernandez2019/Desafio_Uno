package cl.previred.consultadatos.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author gabriel Hernández
 * 
 *         Clase para enviar peticiones a servicios rest utilizando método get
 *         por defecto
 *         
 *
 */
@PropertySource("classpath:api.properties")
public abstract class ClienteRest {

	@Value("${api.header.key}")
	private String headerKey;

	@Value("${api.header.value}")
	private String headerValue;

	/**
	 * 
	 * @param request
	 * @return
	 */
	protected final String getRequest(String request) {

		String body;
		ResponseEntity<String> response;

		RestTemplate restTemplate = new RestTemplate();


		HttpHeaders headers = new HttpHeaders();
		headers.set(headerKey, headerValue);

		response = restTemplate.exchange(request, HttpMethod.GET, new HttpEntity<>(headers), String.class);

		body = response.getBody();

		return body;
	}
}