package com.tienda.service;

import com.tienda.entity.Persona;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Userprincipal implements UserDetails {
    private Persona persona;

    public Userprincipal(Persona persona){
        this.persona = persona;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of permissions (name)
        this.persona.getPermissionList().forEach(permission -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(permission);
            authorities.add(authority);
        });

        // Extract list of roles (ROLE_name)
        this.persona.getRoleList().forEach(role ->{
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
            authorities.add(authority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.persona.getPassword();
    }

    @Override
    public String getUsername() {
        return this.persona.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.persona.getActive() == 1;
    }

}