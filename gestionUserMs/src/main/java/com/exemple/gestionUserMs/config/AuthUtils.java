package com.exemple.gestionUserMs.config;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {
    public static String getAccessToken() {
        KeycloakSecurityContext context = (KeycloakSecurityContext) SecurityContextHolder
                .getContext().getAuthentication().getCredentials();
        return context.getTokenString();
    }
}
