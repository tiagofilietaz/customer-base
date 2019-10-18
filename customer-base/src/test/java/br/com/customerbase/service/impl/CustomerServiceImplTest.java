package br.com.customerbase.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.customerbase.models.Customer;
import br.com.customerbase.repositorys.CustomerRepository;
import br.com.customerbase.service.builder.CustomerBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CustomerServiceImpl.class})
@EnableJpaRepositories("br.com.customerbase.service")
@TestPropertySource(locations = "classpath:application.properties")
public class CustomerServiceImplTest  {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@Test
	@Transactional
    public void deveListarTodosClientesSemSobrenome() {
    	List<Customer> customersWithoutLastName = CustomerBuilder
    			.newCustomer("","email@teste.com")
    			.more(3).buildAll();
    	
    	customersWithoutLastName.stream().forEach(customerServiceImpl::saveCustomer);
    	Integer sizeWithoutLastName = customerServiceImpl.listCustomersWithoutLastName().size();
    	Assert.assertEquals(new Integer(3), sizeWithoutLastName);
    	
    }

}
