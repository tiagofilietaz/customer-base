package br.com.customerbase.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.customerbase.models.Customer;
import br.com.customerbase.models.Email;
import br.com.customerbase.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/api/v1/customer")
@Api(value="customercontroller", produces="Customer Related Operations in the Customer Base")
public class CustomerControllerV1 {

    private static final Logger logger = LoggerFactory.getLogger(CustomerControllerV1.class);

    @Autowired
    private CustomerService service;
    
    @ApiOperation(value = "Add a Customer")
    @PostMapping("/save")
    public String save(@RequestBody final Customer customer) {
    	logger.info("Inserindo cliente");
        try {
        	Email email = service.validateEmail(customer.getEmail());
        	if (validateEmail(email)) {
        		service.saveCustomer(customer);
        	} else {
        		logger.info("Cliente não cadastrado : {}!" , customer.getName());
        		return "Cliente não cadastrado: Email inválido - (" + email.getAddress() + ") !";
        	}

        } catch (Exception e) {
        	logger.info("Cliente não cadastrado : {}!" , customer.getName());
            return "Erro ao cadastrar cliente: " + e.toString();
        }
        
        logger.info("Cliente cadastrado com sucesso cliente id {}",  customer.getId());
        return "Cliente cadastrado com sucesso! (id = " + customer.getId() + " nome = " + customer.getName() + " sobrenome = "  + customer.getLastName() + " email = "  + customer.getEmail();
    }
    
    @ApiOperation(value = "View a list of customers", response = List.class)
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public @ResponseBody List<Customer> list() {
        logger.info("Listando todos os clientes");
        return service.findAll();
    }
    
    @ApiOperation(value = "View a list of customers without Last Name", response = List.class)
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list/withoutlastname")
    public @ResponseBody List<Customer> listCustomersWithoutLastName() {
    	logger.info("Listando todos os clientes sem sobrenome preenchido");
    	return service.listCustomersWithoutLastName();
    }
    
    @ApiOperation(value = "Update a Customer")
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable("id") final Integer id, @RequestBody final Customer customer) {
        logger.info("Atualizando Cliente por id {}", id);
        Customer currentCustomer = service.findId(id);
        if (currentCustomer == null) {
            logger.error("Cliente por id {} nao encontrado.", id);
            return currentCustomer;
        }
        currentCustomer.setName(customer.getName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setEmail(customer.getEmail());
        return service.updateCustomer(currentCustomer);
    }
    
    @ApiOperation(value = "Delete a Customer")
    @DeleteMapping("/delete/{id}")
    public void deleteId(@PathVariable("id") final Integer id) {
        Customer currentCustomer = service.findId(id);
        if (currentCustomer == null) {
            logger.error("Cliente com id {} nao encontrada.", id);
        }
        service.deleteById(id);
    }

    @ApiOperation(value = "Delete all customers")
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        logger.info("Deletando todos os Clientes");
        service.deleteAll();
    }
    
    private Boolean validateEmail (Email email) {
    	if (email.getValidFormat()) {
    		return true;
    	}
		return false; 
    }
}
