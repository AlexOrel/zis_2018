package com.hellokoding.springboot;

import com.hellokoding.springboot.security.AccountAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private AccountAuthenticationProvider accountAuthenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {

        auth.authenticationProvider(accountAuthenticationProvider);

    }

    @Configuration
    public static class ApiWebSecurityConfigurerAdapter
            extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers("/admin/**").authenticated()
                    .and()
                    .formLogin().loginPage("/login").failureUrl("/login?error")
                    .usernameParameter("username").passwordParameter("password")
                    .and()
                    .logout().logoutSuccessUrl("/login?logout");
        }

//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            // @formatter:off
//
//            http.csrf().disable();
//            http
//                         .authorizeRequests()
//                         .antMatchers("/api/**").authenticated()
//                    .and().httpBasic().authenticationEntryPoint(new AuthenticationEntryPoint() {
//                               @Override
//                               public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//                                   // String requestedBy = request.getHeader("X-Requested-With");
//                                   //  if (requestedBy == null || requestedBy.isEmpty()) {
//                                   HttpServletResponse httpResponse = response;
//                                   httpResponse.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//                                   httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
//
//                                   if (authException.getMessage().equals("User type is not trader") || authException.getMessage().equals("User is blocked")
//                                           || authException.getMessage().equals("User's firm is blocked"))
//                                       httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, authException.getMessage());
//                                   else {
//                                       if (authException.getMessage().equals("Password is expired"))
//                                           httpResponse.sendError(HttpServletResponse.SC_RESET_CONTENT, authException.getMessage());
//                                        else
//                                          httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
//                                     }
//                                     httpResponse.addHeader("My header", "");
//                                }
//                                });
//
//
//              /*.and()
//              .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
//
//            // @formatter:on
//
//        }

    }


}
