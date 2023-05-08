package edu.pnu.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.csrf().disable()
                .authorizeHttpRequests(request -> request
                        .antMatchers("/").permitAll()
                        .antMatchers("/member/**").authenticated()
                        .antMatchers("/manager/**").hasRole("MANAGER")
                        .antMatchers("/admin/**").hasRole("ADMIN")
                )
                .formLogin(login -> login
                		.loginPage("/login")
                		.defaultSuccessUrl("/loginSuccess", true)
                		.permitAll()
        		)
                .logout(withDefaults());
        
		return security.build();
	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().
//		withUser("manager").
//		password("{noop}manager123").
//		roles("MANAGER");
//		
//		auth.inMemoryAuthentication().
//		withUser("admin").
//		password("{noop}admin123").
//		roles("ADMIN");
//	}
	
}
