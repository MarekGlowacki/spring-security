package online.javafun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .mvcMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user-panel/**").hasAuthority("ROLE_USER")
                .mvcMatchers(HttpMethod.POST, "/calculate").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();
        );
        http.formLogin(login -> login.loginPage("/login").permitAll());
        http.csrf().disable();
        return http.build();
    }
}