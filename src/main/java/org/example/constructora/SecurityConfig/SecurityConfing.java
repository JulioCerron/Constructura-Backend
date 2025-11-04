package org.example.constructora.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfing {
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Se mantiene el codificador por buena práctica, aunque no se use inmediatamente.
        return new BCryptPasswordEncoder();
    }

    /**
     * Cadena de Filtros que permite todas las peticiones HTTP.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Deshabilita CSRF (típico en APIs REST)
                .csrf(csrf -> csrf.disable())

                // 2. Regla CLAVE: Permite acceso a CUALQUIER petición
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // TODAS las peticiones son permitidas
                )

                // Opcional: Deshabilita el formulario de login y HTTP Basic si no se van a usar
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable());

        return http.build();
    }

}
