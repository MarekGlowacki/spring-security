package online.javafun.springsecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
        http.formLogin(form -> form.loginPage("/login").permitAll());
        http.logout(logout -> logout
                .logoutUrl("/wyloguj")
                .logoutSuccessUrl("/byebye").permitAll()
        );
        http.csrf().disable();
        return http.build();
    }
}