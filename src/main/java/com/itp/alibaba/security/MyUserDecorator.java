package com.itp.alibaba.security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itp.alibaba.model.Role;
import com.itp.alibaba.model.User;

public class MyUserDecorator implements UserDetails {
	
	User user;
	public MyUserDecorator(User user)
	{
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
         
        return authorities;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		LocalDate accountExpiryDate=user.getAccountExpiryDate();
		LocalDate todaysDate=LocalDate.now();
		if(accountExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		int accLockedStatus=user.getAccountLockedStatus();
		if(accLockedStatus==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		LocalDate credentialsExpiryDate=user.getCredentialsExpiryDate();
		LocalDate todaysDate=LocalDate.now();
		if(credentialsExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}

	@Override
	public boolean isEnabled() {
		int accEnabledStatus=user.getAccountEnabledStatus();
		if(accEnabledStatus==1)
			return true;
		else
			return false;
	}

}
