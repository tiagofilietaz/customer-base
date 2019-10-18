package br.com.customerbase.email.service.impl;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.customerbase.email.service.EmailResponseService;
import br.com.customerbase.models.Email;

@Service("EmailResponseService")
public class EmailResponseServiceImpl implements EmailResponseService {

	private static final String FORMAT = "json"; 
	
	private static final String URL_API = "https://api.trumail.io/v2/lookups/" + FORMAT + "?email=";
	
	
	@Override
	public Email getEmail(String email) {
		
		return callSevice(URL_API + email);
	}
	
	private Email callSevice (String url) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Object> entity = new HttpEntity<Object>("parameters", headers);
        ResponseEntity<Email> response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, entity, Email.class);
        }
        catch(RestClientException ex) {
            ex.printStackTrace();
        }
        return response.getBody();
	}
	

}
