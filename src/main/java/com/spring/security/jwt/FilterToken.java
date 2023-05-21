package com.spring.security.jwt;

import com.spring.security.jwt.repository.UserRepositry;
import com.spring.security.jwt.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepositry userRepositry;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token;
        var authorizationdHeader = request.getHeader("Authorization");

        if (authorizationdHeader != null){
            token = authorizationdHeader.replace("Bearer","");
            var subject = this.tokenService.getSubject(token);

            var usuario = this.userRepositry.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario,
                    null,usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }
}
