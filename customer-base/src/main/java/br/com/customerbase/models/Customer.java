package br.com.customerbase.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.util.StringUtils;

@Entity(name = "customer")
public class Customer implements Serializable {

   	private static final long serialVersionUID = -6902605843764067341L;

	@Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
    
    private String lastName;
    
    @NotNull
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean isCustomerWithoutLastName() {
		if(StringUtils.isEmpty(this.lastName)) {
			return true;
		}
		return false;
	}

	
    
}
