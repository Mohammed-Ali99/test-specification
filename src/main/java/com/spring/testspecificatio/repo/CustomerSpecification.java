package com.spring.testspecificatio.repo;

import com.spring.testspecificatio.model.Customer;
import com.spring.testspecificatio.model.CustomerSearch;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification implements Specification<Customer> {

    private CustomerSearch customerSearch;

    public CustomerSpecification(CustomerSearch customerSearch) {
        this.customerSearch = customerSearch;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        // customer name
        if(customerSearch.getName() != null && !customerSearch.getName().isEmpty()) {
            predicates.add(cb.equal(root.get("name") , customerSearch.getName()));
        }

        // email
        if(customerSearch.getEmail() != null && !customerSearch.getEmail().isEmpty()) {
            predicates.add(cb.equal(root.get("email") , customerSearch.getEmail()));
        }

        // address
        if(customerSearch.getAddress() != null && !customerSearch.getEmail().isEmpty()) {
            predicates.add(cb.equal(root.get("address") , customerSearch.getAddress()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
