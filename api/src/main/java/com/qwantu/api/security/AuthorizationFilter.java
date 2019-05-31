package com.qwantu.api.security;

import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthorizationFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);

    @Value("${security.jwt.secret}")
    private String JWT_SECRET;

    @Autowired
    CustomAuthorizationFilterConfiguration customAuthorizationFilterConfiguration;
    @Autowired
    CustomJWTConfiguration customJWTConfiguration;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String header_authorization = req.getHeader("Authorization");
        logger.info("REQUEST URL {}",req.getRequestURL());


        if(header_authorization == null) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, customAuthorizationFilterConfiguration.CUSTOM_ERROR_FORBIDDEN);
        } else {
            String[] resultSplit = header_authorization.split(" ");

            if(resultSplit[0] != null && resultSplit[0].equals(customJWTConfiguration.JWT_TYPE)){
                if(resultSplit[1] != null){
                    logger.info("Your token => {}", resultSplit[1]);
                    System.out.println("OK => todo check the token and check roles + date");
                    //todo => check if hes well formated (same algorithm + secret) => catch try return error
                    //todo => check expiration date => else refresh token or asking for login ?
                    //todo => check role and if user is allow on the path


                    Jwts.parser().setSigningKey("mykey").parseClaimsJws(resultSplit[1]);

                    filterChain.doFilter(servletRequest, servletResponse);
                }

            } else {
                res.sendError(HttpServletResponse.SC_FORBIDDEN, customAuthorizationFilterConfiguration.CUSTOM_ERROR_JWT_TYPE);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
