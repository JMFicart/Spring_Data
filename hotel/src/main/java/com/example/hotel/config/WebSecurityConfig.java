package com.example.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder encoder;

    public WebSecurityConfig(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("pass")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("pass")).roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.httpBasic();

        // Permet d'éviter les cookies
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
//                .antMatchers("/demo/for-all").permitAll()
//                .antMatchers(HttpMethod.GET, "/hotel/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/gerant/**").hasAnyAuthority("USER","ADMIN")
//                // Peut aussi s'ecrire comme cela
//                .antMatchers(HttpMethod.GET, "/gerant/**").hasAnyRole("ROLE_USER","ROLE_ADMIN")
//                .antMatchers(HttpMethod.POST).hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT).hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PATCH).hasAuthority("ADMIN")
//                .antMatchers("/demo/for-connected").authenticated()
//                .antMatchers("/demo/for-user").hasAuthority("USER")
//                .antMatchers("/demo/for-admin").hasAuthority("ADMIN")
                .anyRequest().permitAll();
    }
}
