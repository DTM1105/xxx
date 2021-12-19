package com.nhom8.hethongguitien.service;
import com.nhom8.hethongguitien.model.Tkkh;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public Tkkh saveUser(Tkkh user);
    public List<Tkkh> getAllUsers();
    public List<Tkkh> findById(Integer id);
}
