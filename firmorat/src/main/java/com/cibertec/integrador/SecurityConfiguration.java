package com.cibertec.integrador;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		
		build.jdbcAuthentication()
		.dataSource(dataSource)		
		.usersByUsernameQuery("select username,password,1 from usuario where username=?")		
		.passwordEncoder(passwordEncoder)
		.authoritiesByUsernameQuery("select a.username,d.descripcion from usuario a inner join usuario_trabajador b on a.id_usuario = b.id_usuario inner join trabajador c on b.dni_trabajador =c.dni_trabajador inner join rol d on c.id_rol = d.id_rol where username=?");				
	}
	
}