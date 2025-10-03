package com.spring.springsecurityauthclient.config;



import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthServerRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    /**
     * Convert JWT to GrantedAuthority.
     * @param source
     * @return
     */
    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        List<String> roles = (ArrayList<String>) source.getClaims().get("roles");
        if (roles == null || roles.isEmpty()) {
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> grantedAuthorities = roles.stream().map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return grantedAuthorities;
    }
}
