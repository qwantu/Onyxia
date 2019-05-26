package com.qwantu.api.security;

import org.springframework.stereotype.Component;

@Component
public class CustomAuthorizationFilterConfiguration {
    final String CUSTOM_ERROR_FORBIDDEN = "You are not authorized. Please check your Authorization in your header, JWT Bearer is required to access to the resource.";
    final String CUSTOM_ERROR_JWT_TYPE = "You are not authorized. Please check your Authorization type in your header, JWT Bearer is required to access to the resource.";

}
