package br.com.customerbase.service.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.customerbase.models.Customer;

public class CustomerBuilder {
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	private CustomerBuilder(Customer customer) {
		customers.add(customer);

    }
	
	public static CustomerBuilder newCustomer() {
		Customer customer = create("Name 1", "Last Name 1", "email1@emailteste.com");
		return new CustomerBuilder(customer);
	}

	public static CustomerBuilder newCustomer(String lastName, String email) {
		Customer customer = create("Name 1", lastName, email);
        return new CustomerBuilder(customer);
    }

	private static Customer create(String firstName, String lastName, String email) {
		Customer customer = new Customer();
		customer.setName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		return customer;
	}
	
	public CustomerBuilder more(int number) {
		Customer base = customers.get(0);
		for (int i = 0; i < number; i++) {
			customers.add(create("Name " + i, base.getLastName(), base.getEmail()));
		}
		return this;
	}
	
	public Customer buildOne() {
        return customers.get(0);
    }

    public List<Customer> buildAll() {
        return customers;
    }

}
