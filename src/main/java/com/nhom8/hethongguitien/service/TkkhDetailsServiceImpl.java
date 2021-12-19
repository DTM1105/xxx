package com.nhom8.hethongguitien.service;

import com.nhom8.hethongguitien.model.Tkkh;
import com.nhom8.hethongguitien.model.Tktietkiem;
import com.nhom8.hethongguitien.repository.TkkhRepository;
import com.nhom8.hethongguitien.repository.TktietkiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
@Service
public class TkkhDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TkkhRepository tkkhRepository;
    TktietkiemRepository tktietkiemRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Tkkh tkkh = tkkhRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Tkkh Not Found with username: "+username));
        return TkkhDetailsImpl.build(tkkh);
    }
}
