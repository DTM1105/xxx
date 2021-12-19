package com.nhom8.hethongguitien.service;
import com.nhom8.hethongguitien.model.Tktietkiem;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
@Service
public interface TktietkiemService {
    public Tktietkiem saveTktietkiem(Tktietkiem tktk);
    public List<Tktietkiem> getAllTktietkiems();
    public  List<Tktietkiem> findByIdtktk(int id);
    public  List<Tktietkiem> findBySotkAndId(String sotk, Integer id);
    public Tktietkiem findbySotk(Integer sotk);
    public void getEmployeeAge(int stk,int stk_thanhtoan);
    public void ruttientruocngaytattoan(int stk,int stk_thanhtoan);
    public void taitucvon(int stk,int stk_thanhtoan);
    public void taitucvonlanlai(int stk);
    public Float thongkesotientheothang(int thang,int nam);
    public Float thongkesotientheoquy(int quy,int nam);
    public Float thongkesotientheonam(int nam);
    public List<Tktietkiem> getnewusertheothang(int thang,int nam);
    public List<Tktietkiem> thongketaikhoanmoitheoquy(int quy,int nam);
    public List<Tktietkiem> thongketaikhoanmoitheonam(int nam);
}

