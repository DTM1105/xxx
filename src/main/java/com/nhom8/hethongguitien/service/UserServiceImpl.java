package com.nhom8.hethongguitien.service;

import com.nhom8.hethongguitien.model.Tkkh;
import com.nhom8.hethongguitien.repository.TkkhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private TkkhRepository userRepository;
    @Override
    public Tkkh saveUser(Tkkh user) {
        return userRepository.save(user);
    }

    @Override
    public List<Tkkh> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Tkkh> findById(Integer id) {
        return getAllUsers().stream().filter(user->user.getId()==id).collect(Collectors.toList());
    }
}
