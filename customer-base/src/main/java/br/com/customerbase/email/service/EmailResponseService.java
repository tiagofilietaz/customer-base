package br.com.customerbase.email.service;

import br.com.customerbase.models.Email;

public interface EmailResponseService {
	
	Email getEmail(String email);
	
}
