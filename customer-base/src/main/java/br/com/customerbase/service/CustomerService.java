package br.com.customerbase.service;

import br.com.customerbase.models.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Iterable<Customer> findAll();

    Customer findId(Integer id);

    Customer updateCustomer(Customer customer);

    void deleteById(Integer id);

    void deleteAll();

}
