package com.nhom8.hethongguitien.service;

import com.nhom8.hethongguitien.model.Tktietkiem;
import com.nhom8.hethongguitien.repository.TktietkiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TktietkiemServiceImpl implements TktietkiemService {
    @Autowired
    private TktietkiemRepository tktietkiemRepository;
    @PersistenceContext
    EntityManager em;

    @Override
    public Tktietkiem saveTktietkiem(Tktietkiem tktk) {
        return tktietkiemRepository.save(tktk);
    }

    @Override
    public List<Tktietkiem> getAllTktietkiems() {
        return tktietkiemRepository.findAll();
    }
    @Override
    public List<Tktietkiem> findByIdtktk(int id) {
        //return getAllTktietkiems().stream().filter(user -> user.getTkkh().getId() == id).collect(Collectors.toList());
        return getAllTktietkiems().stream().filter(user -> user.getId() == id).collect(Collectors.toList());
//       Tktietkiem  tktietkiems = tktietkiemDao.findByIdtktk(id);
//        return tktietkiems;
    }

    @Override
    public Tktietkiem findbySotk(Integer sotk) {
        return tktietkiemRepository.getById(sotk);
    }

    @Override
    public List<Tktietkiem> findBySotkAndId(String sotk, Integer id) {
        //return getAllTktietkiems().stream().filter(user -> user.getTkkh().getId() == id && user.getSotk() == sotk).collect(Collectors.toList());
        return getAllTktietkiems().stream().filter(user -> user.getId() == id).collect(Collectors.toList());
    }

    @Override
    public void getEmployeeAge(int stk, int stk_thanhtoan) {
         tktietkiemRepository.NqGetEmployeeAge(stk,stk_thanhtoan);
    }

    @Override
    public void ruttientruocngaytattoan(int stk, int stk_thanhtoan) {
        tktietkiemRepository.Nqruttientruocngaytattoan(stk,stk_thanhtoan);
    }

    @Override
    public void taitucvon(int stk, int stk_thanhtoan) {
        tktietkiemRepository.Nqtaitucvon(stk,stk_thanhtoan);
    }

    @Override
    public void taitucvonlanlai(int stk) {
        tktietkiemRepository.Nqtaitucvonlanlai(stk);
    }

    @Override
    public Float thongkesotientheothang(int thang, int nam) {
        return tktietkiemRepository.Nqthongkesotientheothang(thang,nam);
    }

    @Override
    public Float thongkesotientheoquy(int quy, int nam) {
        return tktietkiemRepository.Nqthongkesotientheoquy(quy,nam);
    }
    @Override
    public Float thongkesotientheonam(int nam) {
        return tktietkiemRepository.Nqthongkesotientheonam(nam);
    }

    @Override
    public List<Tktietkiem> getnewusertheothang(int thang, int nam) {
        return tktietkiemRepository.Nqnewusertheothang(thang,nam);
    }

    @Override
    public List<Tktietkiem> thongketaikhoanmoitheoquy(int quy, int nam) {
        return tktietkiemRepository.Nqthongketaikhoanmoitheoquy(quy,nam);
    }
    @Override
    public List<Tktietkiem> thongketaikhoanmoitheonam( int nam) {
        return tktietkiemRepository.Nqthongketaikhoanmoitheonam(nam);
    }
}
