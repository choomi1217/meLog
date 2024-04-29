package cho.me.melog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll()
                ).csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(withDefaults -> withDefaults.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
        /*return httpSecurity.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(
                                        "/swagger-ui/**"
                                        , "/swagger-resources/**"
                                        , "/v3/api-docs/**"
                                        , "/login"
                                        , "/signup"
                                        , "/favicon.ico"
                                        , "/error").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(withDefaults -> withDefaults.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();*/
    }


}

