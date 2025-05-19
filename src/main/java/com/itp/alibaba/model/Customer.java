package com.itp.alibaba.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custid")  // Remove 'length' for integer fields
    private int custId;  // No length parameter needed for INT

    @Column(name = "custname")
    private String custName;

    @Column(unique = true, name = "custemail")
    private String custEmail;

    @Column(unique = true, name = "custmobile", length = 10, nullable = false)
    private String custMobile;

    private String custGender;
    
    private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
	
	@PrePersist
	protected void atCreation()
	{
		LocalDateTime now=LocalDateTime.now();
		this.createdAt=now;
		this.modifiedAt=now;
	}
	
	@PreUpdate
	protected void atUpdation()
	{
		this.modifiedAt=LocalDateTime.now();
	}

}
