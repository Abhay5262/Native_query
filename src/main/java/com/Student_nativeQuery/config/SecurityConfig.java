package com.Student_nativeQuery.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {
	
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(requests -> requests
                .antMatchers("/getstudentbyrollno/**") .hasRole("ADMIN")
                .antMatchers("/getallstudent") .hasRole("NORMAL")
                .anyRequest()
                .authenticated())
        .formLogin(Customizer.withDefaults())
        .logout(Customizer.withDefaults());

		return httpSecurity.build();
}
	

	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails normalUser = org.springframework.security.core.userdetails.User
				.withUsername("Abhay")
				.password(passwordEncoder().encode("123"))
				.roles("ADMIN")
				.build();
		
		UserDetails adminUser = org.springframework.security.core.userdetails.User
				.withUsername("Prince")
				.password(passwordEncoder().encode("456"))
				.roles("NORMAL")
				.build();
		return new InMemoryUserDetailsManager(normalUser,adminUser);
}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
