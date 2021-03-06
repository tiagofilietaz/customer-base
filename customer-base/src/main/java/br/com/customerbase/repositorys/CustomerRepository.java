package br.com.customerbase.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.customerbase.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findById(@Param("idParam") Integer id);
    
   
    
}
