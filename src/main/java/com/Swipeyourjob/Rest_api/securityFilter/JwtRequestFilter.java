package com.Swipeyourjob.Rest_api.securityFilter;

import io.jsonwebtoken.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
            try{

                final String requestTokenHeader = request.getHeader("Authorization");
                System.out.println(requestTokenHeader);

                if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            null, null, null);
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    logger.warn("We love you");
                }else{
                    logger.warn("JWT Token does not begin with Bearer String");
                }
                chain.doFilter(request, response);
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }
