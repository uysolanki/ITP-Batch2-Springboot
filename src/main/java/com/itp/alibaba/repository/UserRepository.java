package com.itp.alibaba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.alibaba.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
			public User findByUsername(String x);
}
