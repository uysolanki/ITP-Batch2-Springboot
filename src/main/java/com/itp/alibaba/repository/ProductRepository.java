package com.itp.alibaba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.alibaba.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
