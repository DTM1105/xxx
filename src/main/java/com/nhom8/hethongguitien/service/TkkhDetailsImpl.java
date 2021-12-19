package com.nhom8.hethongguitien.service;

import com.nhom8.hethongguitien.model.Tkkh;
import com.nhom8.hethongguitien.model.Tktietkiem;
import com.nhom8.hethongguitien.repository.TkkhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
public class TkkhDetailsImpl implements UserDetails {
    private static final long serialVersionUID=1L;
    private Integer id;
    private String username;
    private String email;
    private String tenkh;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    public TkkhDetailsImpl(Integer id,String username, String email,String tenkh,String password,
                           Collection<? extends GrantedAuthority> authorities){
        this.id=id;
        this.username=username;
        this.email=email;
        this.password=password;
        this.tenkh=tenkh;
        this.authorities=authorities;
    }
    public static TkkhDetailsImpl build(Tkkh tkkh) {
        List<GrantedAuthority> authorities = tkkh.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new TkkhDetailsImpl(
                tkkh.getId(),
                tkkh.getUsername(),
                tkkh.getEmail(),
                tkkh.getTenkh(),
                tkkh.getPassword(),
                authorities);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

//    public Integer getId() {
//        return id;
//    }


    public Integer getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getTenkh() {
        return tenkh;
    }

    @Override
    public String getPassword() {
        return password;
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
        return true;
    }
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        TkkhDetailsImpl tkkh = (TkkhDetailsImpl) o;
       return Objects.equals(id,tkkh.id);
    }
}
