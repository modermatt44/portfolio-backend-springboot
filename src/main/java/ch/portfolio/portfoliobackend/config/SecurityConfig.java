package ch.portfolio.portfoliobackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.net.URI;
import java.util.*;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  //private JwtAuthEntryPoint jwtAuthEntryPoint;
  //private CustomUserDetailsService customUserDetailsService;
//
  //@Autowired
  //public SecurityConfig(JwtAuthEntryPoint jwtAuthEntryPoint, CustomUserDetailsService customUserDetailsService) {
  //    this.jwtAuthEntryPoint = jwtAuthEntryPoint;
  //    this.customUserDetailsService = customUserDetailsService;
  //}

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Collections.singletonList("https://odermattmarco.ch"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public GrantedAuthoritiesMapper userAuthoritiesMapper() {
    return (authorities) -> {
      List<GrantedAuthority> mappedAuthorities = new ArrayList<>();

      // Add default user role
      mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

      // Add other authorities
      mappedAuthorities.addAll(authorities);

      return mappedAuthorities;
    };
  }

  // Security filter chain
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    Set<String> googleScopes = new HashSet<>();
    googleScopes.add("https://www.googleapis.com/auth/userinfo.email");
    googleScopes.add("https://www.googleapis.com/auth/userinfo.profile");

    OidcUserService googleUserService = new OidcUserService();
    googleUserService.setAccessibleScopes(googleScopes);

    http
            .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            //.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(jwtAuthEntryPoint))
            //.sessionManagement(sessionManagement ->
            //        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.GET, "/oauth2/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/login").permitAll()
                    .requestMatchers(HttpMethod.GET, "/logout").permitAll()
                    .requestMatchers(HttpMethod.GET, "/get_language").permitAll()
                    .requestMatchers(HttpMethod.GET, "/get_project").permitAll()
                    .requestMatchers(HttpMethod.GET, "/get_programming_language").permitAll()
                    .requestMatchers(HttpMethod.GET, "/get_program").permitAll()
                    .requestMatchers(HttpMethod.GET, "/favicon.ico").permitAll()
                    .anyRequest().authenticated()
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/").permitAll()
            )
            .oauth2Login(o -> o.userInfoEndpoint(u -> u.oidcUserService(googleUserService).userAuthoritiesMapper(userAuthoritiesMapper())));
    //http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  //@Bean
  //public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
  //    return authenticationConfiguration.getAuthenticationManager();
  //}

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  //@Bean
  //public JWTAuthenticationFilter jwtAuthenticationFilter() {
  //    return new JWTAuthenticationFilter();
  //}


}
