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
                        // lo que podemos acceder sin autenticacion , y permite mostarse
                        .requestMatchers("/styles/**", "/js/**", "/bootstrap/**", "/img/**").permitAll()

                        // el accceso al home es para todos los usuaros autienticfados
                        .requestMatchers("/home").authenticated()

                        // Usuarios con rol de admin
                        .requestMatchers("/usuarios/**").hasRole("admin")
                        .requestMatchers("/roles/**").hasRole("admin")

                        // usuarios con rol de admin y comercial
                        .requestMatchers("/peliculas/nueva").hasAnyRole("admin", "commercial")

                        // usuarios cualquier rol autenticado
                        .requestMatchers("/peliculas/listar").authenticated()

                        // para cualqier otra cosa se neceista autenticacion
                        .anyRequest().authenticated())
                         // configuración del formulario de login 
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginprocess")
                        .defaultSuccessUrl("/home", true)
                        .permitAll())

                .logout(logout -> logout.permitAll());

        return http.build();
    }
    // si nos conectamos con usuarios en memoria o con base de datos necesitamos un encoder si o si
    // este funcuiona para usuarios en memoria sin encriptar y en una base de datos tambien sin encriptar
    @Bean
    @SuppressWarnings("deprecation")
    PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
        return encoder;
    }

}
