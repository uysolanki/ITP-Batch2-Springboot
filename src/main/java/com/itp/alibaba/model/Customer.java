package com.itp.alibaba.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
    
    @CreatedDate 
    @Column(name = "created_at") 
    private Timestamp createdAt; 

    @LastModifiedDate 
    @Column(name = "modified_at") 
    private Timestamp modifiedAt;

}
