package br.com.customerbase.service;

import java.util.List;

import br.com.customerbase.models.Customer;
import br.com.customerbase.models.Email;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> findAll();

    Customer findId(Integer id);

    Customer updateCustomer(Customer customer);

    void deleteById(Integer id);

    void deleteAll();
    
    Email validateEmail(String email);
    
    List<Customer> listCustomersWithoutLastName();

}
