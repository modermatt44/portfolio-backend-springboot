package ch.portfolio.portfoliobackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .passwordEncoder(passwordEncoder()::encode)
                        .username(username)
                        .password(password)
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("https://odermattmarco.ch"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    // Security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/post_language").authenticated()
                        .requestMatchers("/post_program").authenticated()
                        .requestMatchers("/post_programming_language").authenticated()
                        .requestMatchers("/post_project").authenticated()
                        .requestMatchers("/delete_language").authenticated()
                        .requestMatchers("/delete_program").authenticated()
                        .requestMatchers("/delete_programming_language").authenticated()
                        .requestMatchers("/delete_project").authenticated()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/get_language").permitAll()
                        .requestMatchers("/get_program").permitAll()
                        .requestMatchers("/get_programming_language").permitAll()
                        .requestMatchers("/get_project").permitAll()
                        .requestMatchers("/get_token").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(userDetailsService())
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();
    }

}
