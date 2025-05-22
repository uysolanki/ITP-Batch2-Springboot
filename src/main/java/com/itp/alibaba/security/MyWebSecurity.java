package com.itp.alibaba.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class MyWebSecurity extends WebSecurityConfigurerAdapter
{
@Override   //Autentication
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.inMemoryAuthentication()
		.withUser("abc")
		.password("abc")		// cleartext
		.authorities("ADMIN")
		.and()
		.withUser("xyz")
		.password("xyz")		// cleartext
		.authorities("USER");
}

 
@Override  //Authorisation
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
    .antMatchers("/allproducts","/addproductform","/403").hasAnyAuthority("USER","ADMIN")
    .antMatchers("/deleteProductFE/**","/updateProductForm/**").hasAuthority("ADMIN")
    .anyRequest().authenticated()
    .and()
    .formLogin().loginProcessingUrl("/login").successForwardUrl("/allproducts").permitAll()
    .and()
    .logout().logoutSuccessUrl("/login").permitAll()
    .and()
    .exceptionHandling().accessDeniedPage("/403")
    .and()
    .cors().and().csrf().disable();


	}

@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
