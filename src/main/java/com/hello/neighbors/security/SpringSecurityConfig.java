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
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

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
        http.cors().configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(List.of("http://localhost:4200"));
                    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    config.setAllowedHeaders(List.of("*"));
                    config.setAllowCredentials(true);
                    return config;
                })
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .requestMatchers("/api/rest/hello/neighbors/security/**").permitAll()
                .requestMatchers("/api/rest/hello/neighbors/landing/**").permitAll()
                .requestMatchers("/api/rest/hello/neighbors/profile/update").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/profile/update/bio").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/profile/user/{id}/infos").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/publication/create").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/publication/delete").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/publication/update").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/publication/all/publications").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/publication/user/{id}/publications").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/publication/like").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/publication/dislike").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/comment/publish").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/comment/delete").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/comment/update").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/event/create").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/event/join").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/event/leave").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/event/like").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/event/dislike").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/event/cancel").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/event/all/events").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/event/update").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/notification/read").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/notification/archive").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/notification/delete").hasAuthority("USER")
                .requestMatchers("/api/rest/hello/neighbors/admin/**").hasAuthority("ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/home/display/all").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/api/rest/hello/neighbors/home/display/random/user/pictures").hasAnyAuthority("USER", "ADMIN");

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
