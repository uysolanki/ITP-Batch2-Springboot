package com.itp.alibaba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.alibaba.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
