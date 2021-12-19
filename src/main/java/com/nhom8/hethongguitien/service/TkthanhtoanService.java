package com.nhom8.hethongguitien.service;

import com.nhom8.hethongguitien.model.Tkthanhtoan;
import com.nhom8.hethongguitien.model.Tktietkiem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TkthanhtoanService {
    public Tkthanhtoan saveTkthanhtoan(Tkthanhtoan tktk);
    public List<Tkthanhtoan> getAllTkthanhtoans();
    public  List<Tkthanhtoan> findByIdtktt(int id);
   // public  List<> findBySotkAndId(String sotk, Integer id);
    public Tkthanhtoan findbySotk(Integer sotk);
}
