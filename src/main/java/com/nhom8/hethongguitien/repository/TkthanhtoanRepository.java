package com.nhom8.hethongguitien.repository;

import com.nhom8.hethongguitien.model.Tkthanhtoan;
import com.nhom8.hethongguitien.model.Tktietkiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TkthanhtoanRepository extends JpaRepository<Tkthanhtoan,Integer> {

}
