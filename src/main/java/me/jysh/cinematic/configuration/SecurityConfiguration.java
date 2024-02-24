package me.jysh.cinematic.configuration;



import me.jysh.cinematic.service.UserService;
import me.jysh.cinematic.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.Customizer;
import java.util.Collections;

@Configuration
        @EnableWebSecurity
        public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserServiceImpl userServiceImpl;

//            @Bean
//            public UserService userService() {
//                return  new UserServiceImpl();
//            }
//
//            @Bean
//            public BCryptPasswordEncoder passwordEncoder() {
//                return new BCryptPasswordEncoder();
//            }
//            @Bean
//            public DaoAuthenticationProvider authenticationProvider() {
//                DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//                authProvider.setUserDetailsService(userDetailsService());
//                authProvider.setPasswordEncoder(passwordEncoder());
//                return authProvider;
//            }

//            @Override
//            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//                auth.authenticationProvider(authenticationProvider());
//            }
//            @Override
//            protected void configure(HttpSecurity http) throws Exception {
//                http.csrf().disable().
//                        formLogin().loginPage("/login")
//                        .permitAll();
//            @Override
//            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//                auth.userDetailsService(userServiceImpl);
//            }
//                @Override
//                protected void configure(HttpSecurity http) throws Exception {
//                    http.csrf().disable().authorizeRequests()
//                         .anyRequest().authenticated().and()
//                            .formLogin()
//                            .loginPage("/login")
//                            .permitAll();
//                }
//                http.authorizeRequests()
//                        .anyRequest().authenticated()
//                        .and()
//                        .formLogin().permitAll()
//                        .and()
//                        .logout().permitAll();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest()

                .authenticated().and()
                .formLogin().loginPage("/login").permitAll();
        http.csrf().disable();
    }
    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl);
    }

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(authorizeRequests -> authorizeRequests..authenticated())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//    }
}

   //     }

