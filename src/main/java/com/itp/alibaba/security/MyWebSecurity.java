package com.itp.alibaba.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class MyWebSecurity// extends WebSecurityConfigurerAdapter
{
//@Override   //Autentication
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	 auth.inMemoryAuthentication()
//		.withUser("abc")
//		.password("abc")		// cleartext
//		.authorities("ADMIN")
//		.and()
//		.withUser("xyz")
//		.password("xyz")		// cleartext
//		.authorities("USER");
//	    auth.authenticationProvider(myAuthenticationProvider());	
//}

@Bean
public AuthenticationProvider myAuthenticationProvider() {
	DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
	daoProvider.setUserDetailsService(mySetUserDetailsService());
	daoProvider.setPasswordEncoder(mySetPasswordEncoder());
	return daoProvider;
}


@Bean
public PasswordEncoder mySetPasswordEncoder() {
	return new BCryptPasswordEncoder();
}


@Bean
public UserDetailsService mySetUserDetailsService() {
	return new MyUserDetailsService();
}


//@Override  //Authorisation
//	protected void configure(HttpSecurity http) throws Exception {
//	http.authorizeRequests()
//    .antMatchers("/allproducts","/addproductform","/403").hasAnyAuthority("USER","ADMIN")
//    .antMatchers("/deleteProductFE/**","/updateProductForm/**").hasAuthority("ADMIN")
//    .anyRequest().authenticated()
//    .and()
//    .formLogin().loginProcessingUrl("/login").successForwardUrl("/allproducts").permitAll()
//    .and()
//    .logout().logoutSuccessUrl("/login").permitAll()
//    .and()
//    .exceptionHandling().accessDeniedPage("/403")
//    .and()
//    .cors().and().csrf().disable();
//
//
//	}

//@Bean
//	public PasswordEncoder getPasswordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}


@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
   
	http.authorizeRequests()
    .requestMatchers("/allproducts","/addproductform","/403").hasAnyAuthority("USER","ADMIN")
    .requestMatchers("/deleteProductFE/**","/updateProductForm/**").hasAuthority("ADMIN")
    .anyRequest().authenticated()
    .and()
    .formLogin().loginProcessingUrl("/login").successForwardUrl("/allproducts").permitAll()
    .and()
    .logout().logoutSuccessUrl("/login").permitAll()
    .and()
    .exceptionHandling().accessDeniedPage("/403")
    .and()
    .cors().and().csrf().disable();
	
	http.authenticationProvider(myAuthenticationProvider());
    return http.build();
}

}
