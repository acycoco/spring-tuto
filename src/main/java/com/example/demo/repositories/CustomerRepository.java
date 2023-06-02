package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> { //자동으로 만들어줌 crud
    List<Customer> findByLastName(String lastName); //JPA가 자동으로 구현
    Customer findById(long id);

}
