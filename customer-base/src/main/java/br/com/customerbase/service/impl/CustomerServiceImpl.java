package br.com.customerbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.customerbase.models.Customer;
import br.com.customerbase.repositorys.CustomerRepository;
import br.com.customerbase.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer saveCustomer(final Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findId(final Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Customer updateCustomer(final Customer customer) {
        return repository.saveAndFlush(customer);
    }

    @Override
    public void deleteById(final Integer id) {
        repository.delete(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }


}
