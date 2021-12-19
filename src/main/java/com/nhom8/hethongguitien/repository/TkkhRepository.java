package com.nhom8.hethongguitien.repository;

import com.nhom8.hethongguitien.model.Tkkh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TkkhRepository extends JpaRepository<Tkkh,Integer> {

    Optional<Tkkh> findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
