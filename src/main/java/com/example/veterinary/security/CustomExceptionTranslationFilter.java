package com.example.veterinary.security;

import com.example.veterinary.config.AuthEntryPoint;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

@Component
public class CustomExceptionTranslationFilter extends ExceptionTranslationFilter {

    @Autowired
    public CustomExceptionTranslationFilter(AuthEntryPoint authEntryPoint) {
        super(authEntryPoint);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (AuthenticationException e){
            sendStartAuthentication((HttpServletRequest) request, (HttpServletResponse) response, chain, e);
        } catch (AccessDeniedException e){
            System.out.println("AccessDeniedException");

        }
    }
}
