package com.metacube.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Config file for Authentication
 * @author Surender
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(new StudentConfig().getDataSource()).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
				.authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username = ?");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/home").hasAuthority("USER").antMatchers("/showStudent")
				.hasAuthority("ADMIN").and().formLogin().loginPage("/login").defaultSuccessUrl("/home", true)
				.failureUrl("/login?error=true").and().csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
