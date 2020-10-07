package com.iaito.config;

import com.iaito.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers(HttpMethod.GET,
                            "/",
                            "/*.html",
                            "/favicon.ico",
                            "/**/*.html",
                            "/**/*.css",
                            "/**/*.js",
                            "/h2-console/**",
                            "/api/**").permitAll()
                    .antMatchers("/dashboard").hasRole("ADMIN")
                    .antMatchers("/mapview").hasRole("ADMIN")
                    .antMatchers("/container_*").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/rfid*").hasRole("ADMIN")
                    .antMatchers("/vehicleDevice*").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/vehicle_*").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/reader_*").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/user_*").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()

                .and()
                .formLogin()
                    .loginPage("/login")
                        .usernameParameter("username").passwordParameter("password").permitAll()
                    .loginProcessingUrl("/doLogin")
                    .successForwardUrl("/postLogin")
                    .failureUrl("/loginFailed")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDenied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resource/**","/static/**", "/webjars/**",  "/css/**");
    }
}
