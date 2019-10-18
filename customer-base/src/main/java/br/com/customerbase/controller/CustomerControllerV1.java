package br.com.customerbase.controller;

import java.util.ArrayList;
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
import br.com.customerbase.service.CustomerService;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/api/v1/customer")
public class CustomerControllerV1 {

    private static final Logger logger = LoggerFactory.getLogger(CustomerControllerV1.class);

    @Autowired
    private CustomerService service;

    @PostMapping("/save")
    public String save(@RequestBody final Customer customer) {

        try {
            service.saveCustomer(customer);

        } catch (Exception e) {
            return "Erro ao cadastrar cliente: " + e.toString();
        }
        return "Cliente cadastrado com sucesso! (id = " + customer.getId() + " nome = " + customer.getName() + " sobrenome = "  + customer.getLastName();
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<Customer> list() {
        logger.info("Listando todos os clientes");
        return service.findAll();
    }
    
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
        currentCustomer.setCpf(customer.getCpf());

        return service.updateCustomer(currentCustomer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteId(@PathVariable("id") final Integer id) {

        Customer currentCustomer = service.findId(id);

        if (currentCustomer == null) {
            logger.error("Cliente com id {} nao encontrada.", id);
        }
        service.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {

        logger.info("Deletando todos os Clientes");
        service.deleteAll();
    }
}
