package com.spring.testspecificatio.repo;

import com.spring.testspecificatio.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer , Long> , JpaSpecificationExecutor<Customer> {


}
