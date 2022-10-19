package com.metro.repository;

import org.springframework.data.repository.CrudRepository;

import com.metro.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}