package com.hello.neighbors.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private JwtAuthenticationFilter jwtAuthenticationFilter;

    ////////////// Beans //////////////

    /**
     * Cette méthode établit des règles claires sur qui peut voir quoi
     * et ajoute une sécurité supplémentaire pour vérifier l’authenticité
     * des utilisateurs avant de leur donner accès à certaines parties du site.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .requestMatchers("/api/rest/hello/neighbors/security/**").permitAll()
                .requestMatchers("/api/rest/hello/neighbors/landing/**").permitAll()
                .requestMatchers("/api/rest/hello/neighbors/publication/create").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/publication/delete").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/publication/update").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/comment/publish").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/comment/delete").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/comment/update").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/admin/**").hasAuthority("ADMIN");

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return  http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    ////////////// Setters //////////////

    @Autowired
    public void setJwtAuthenticationFilter(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
}
