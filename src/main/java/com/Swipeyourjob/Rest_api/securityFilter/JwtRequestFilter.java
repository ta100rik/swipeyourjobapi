package com.Swipeyourjob.Rest_api.securityFilter;

import com.Swipeyourjob.Rest_api.services.ServiceProvider;
import io.jsonwebtoken.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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


                response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
                response.setHeader("Access-Control-Allow-Credentials","true");
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, authorization, x-auth-token");
                final String requestTokenHeader = request.getHeader("Authorization");
                if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                    String jwtToken = requestTokenHeader.substring(7);
                    String role = ServiceProvider.getAuthenticationService().getUserRole(jwtToken);
                    int userid = ServiceProvider.getAuthenticationService().getUserid(jwtToken);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            role + "_" + userid, null, null);
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }else{
                    logger.warn("JWT Token does not begin with Bearer String");
                }
                if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                    response.setStatus(HttpServletResponse.SC_OK);
                } else {
                    chain.doFilter(request,response);
                }
            }catch (Exception e){

            }
        }

    }
