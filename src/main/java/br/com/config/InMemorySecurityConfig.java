package br.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * Classe responsável por solicitar login e senha
 * do usuárrio antes de acessar o sistema.
 * @author Carvalho
 * @since  20/11/2017
 * @version 1.0
 */
@Configuration
public class InMemorySecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)
	throws Exception {
	builder
	.inMemoryAuthentication()
	.withUser("dinho").password("123").roles("USER")
	.and()
	.withUser("user").password("123").roles("USER")
	.and()
	.withUser("admin").password("123").roles("USER");
	}

}
