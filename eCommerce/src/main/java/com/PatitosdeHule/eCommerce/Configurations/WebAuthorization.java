package com.PatitosdeHule.eCommerce.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
        http.authorizeRequests()

            .antMatchers("/api/products").permitAll()
            .antMatchers("/api/products/clothes").permitAll()
            .antMatchers("/api/products/cosplay").permitAll()
            .antMatchers("/api/products/{id}").permitAll()
            .antMatchers("/api/clients/current").hasAuthority("CLIENT")
            .antMatchers("/api/invoicesdto").hasAuthority("CLIENT")
            .antMatchers(HttpMethod.PATCH, "/api/products/status", "/api/products/stock").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.POST, "/api/products/cosplay", "/api/products/clothes").hasAuthority("ADMIN")
            .antMatchers("/web/manager/**").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.POST, "/api/invoices/create").hasAuthority("CLIENT")
            .antMatchers(HttpMethod.PATCH, "/api/products").hasAuthority("CLIENT")
            .antMatchers("/api/invoices/createPDF", "/web/checkout.html").hasAuthority("CLIENT")
            .antMatchers(HttpMethod.POST, "/api/clients").permitAll()
            .antMatchers("/web/**", "/web/styles/**", "/web/sources/**", "/web/assets/**").permitAll()
            .antMatchers("/**").hasAuthority("ADMIN");
//           .antMatchers(HttpMethod.PATCH, "/api/**").permitAll()
  //         .antMatchers(HttpMethod.POST, "/api/**").permitAll()
    //       .antMatchers("/api/**", "/**").permitAll()
      //     .antMatchers("/api/invoices/**").permitAll()
        //   .antMatchers("/web/**", "/web/styles/**", "/web/sources/**", "/web/assets/**").permitAll()




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
