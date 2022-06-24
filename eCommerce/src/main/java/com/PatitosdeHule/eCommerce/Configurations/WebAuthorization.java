package com.PatitosdeHule.eCommerce.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@EnableWebSecurity
@Configuration
public class WebAuthorization extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
<<<<<<< HEAD
        http.authorizeRequests()
               .antMatchers("/**").permitAll();
//                .antMatchers("/rest/**", "/h2-console/**", "/admin/**").hasAuthority("ADMIN")
//                .antMatchers("/web/**", "/web/styles/**", "/web/sources/**", "/web/assets/**").permitAll();
=======

        http.authorizeRequests()

            .antMatchers("/api/**", "/**").permitAll();
//            .antMatchers("/rest/**", "/h2-console/**", "/admin/**").hasAuthority("ADMIN")
//            .antMatchers("/web/**", "/web/styles/**", "/web/sources/**", "/web/assets/**").permitAll()
//            .antMatchers("/api/products/clothes").permitAll()
//            .antMatchers("/api/products/cosplay").permitAll()
>>>>>>> c832c9e2c8db4c1b33ac81bf2a87bfc5ed7dc046

        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginPage("/api/login");

        http.logout().logoutUrl("/api/logout");

        http.csrf().disable();

        http.headers().frameOptions().disable();

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {

            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        }

    }
}
