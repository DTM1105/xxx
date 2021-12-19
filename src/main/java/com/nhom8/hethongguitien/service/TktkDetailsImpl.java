//package com.nhom8.hethongguitien.service;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.nhom8.hethongguitien.model.Tktietkiem;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//public class TktkDetailsImpl implements UserDetails {
//    private static final long serialVersionUID=1L;
//    private String sotk;
//    private String tenkh;
//    public TktkDetailsImpl(String sotk,String tenkh){
//        this.sotk=sotk;
//        this.tenkh=tenkh;
//    }
//    public static TktkDetailsImpl build(Tktietkiem tktk){
//        return new TktkDetailsImpl(
//               tktk.getSotk(),
//                tktk.getTenkh());
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        return authorities;
//    }
//
//    public String getSotk() {
//        return sotk;
//    }
//
//    public void setSotk(String sotk) {
//        this.sotk = sotk;
//    }
//
//    public String getTenkh() {
//        return tenkh;
//    }
//
//    public void setTenkh(String tenkh) {
//        this.tenkh = tenkh;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//    @Override
//    public boolean equals(Object o){
//        if(this==o)
//            return true;
//        if(o == null || getClass() != o.getClass())
//            return false;
//        TktkDetailsImpl tktk = (TktkDetailsImpl) o;
//        return Objects.equals(sotk,tktk.sotk);
//    }
//}
