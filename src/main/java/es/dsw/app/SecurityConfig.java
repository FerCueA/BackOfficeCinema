package es.dsw.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // para permitir sin autenticar
                        .requestMatchers("/styles/**", "/js/**", "/bootstrap/**", "/img/**").permitAll()
                        .anyRequest().authenticated())

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginprocess")
                        // para que cargue por defecto la pagina principal despues del login (pop-up)
                        .defaultSuccessUrl("/home", true)
                        .permitAll())

                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    // Tenemos que poner si o si este PasswordEncoder para que no de error al iniciar sesion
    @SuppressWarnings("deprecation")
    PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
        return encoder;
    }
}
