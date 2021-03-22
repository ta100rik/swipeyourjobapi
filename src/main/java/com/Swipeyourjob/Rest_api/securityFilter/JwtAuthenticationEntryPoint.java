package com.Swipeyourjob.Rest_api.securityFilter;

import io.jsonwebtoken.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        } catch (java.io.IOException e) {
            e.printStackTrace();

        }
    }
}
