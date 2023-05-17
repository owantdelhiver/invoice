package fr.owen.facturier.security;

import fr.owen.facturier.service.AdminServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    UserDetailsService customUserDetailsService() {
        return new AdminServiceImpl();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService());
        return provider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {
        http.authorizeHttpRequests()
                .anyRequest().hasAnyAuthority("ADMIN");
        http.formLogin()
                .usernameParameter("mail")
                .passwordParameter("password");
        http.logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");

        return http.build();
    }
}
