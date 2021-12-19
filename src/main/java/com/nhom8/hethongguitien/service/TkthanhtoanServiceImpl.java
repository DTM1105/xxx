package com.nhom8.hethongguitien.service;

import com.nhom8.hethongguitien.model.Tkthanhtoan;
import com.nhom8.hethongguitien.repository.TkthanhtoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TkthanhtoanServiceImpl implements TkthanhtoanService {
    @Autowired
    private TkthanhtoanRepository tkthanhtoanRepository;
    @Override
    public Tkthanhtoan saveTkthanhtoan(Tkthanhtoan tktt) {
        return tkthanhtoanRepository.save(tktt);
    }

    @Override
    public List<Tkthanhtoan> getAllTkthanhtoans() {
        return tkthanhtoanRepository.findAll();
    }

    @Override
    public List<Tkthanhtoan> findByIdtktt(int id) {
        return getAllTkthanhtoans().stream().filter(user -> user.getId() == id).collect(Collectors.toList());
    }

    @Override
    public Tkthanhtoan findbySotk(Integer sotk) {
        return tkthanhtoanRepository.getById(sotk);
    }
}
