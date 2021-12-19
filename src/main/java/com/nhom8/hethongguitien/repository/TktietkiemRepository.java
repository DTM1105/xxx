package com.nhom8.hethongguitien.repository;
import com.nhom8.hethongguitien.model.Tktietkiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public interface TktietkiemRepository extends JpaRepository<Tktietkiem,Integer> {
    Optional<Tktietkiem> findBySotk(Integer sotk);
    Boolean existsBySotk(Integer sotk);
    @Procedure
    void ruttiendungngaytattoan(Integer sotk, Integer stk);

    @Query(value ="call ruttiendungngaytattoan(?1,?2)", nativeQuery = true)
    void NqGetEmployeeAge(int stk,int stk_thanhtoan);

    @Query(value ="call ruttientruocngaytattoan(?1,?2)", nativeQuery = true)
    void Nqruttientruocngaytattoan(int stk,int stk_thanhtoan);

    @Query(value ="call taitucvon(?1,?2)", nativeQuery = true)
    void Nqtaitucvon(int stk,int stk_thanhtoan);

    @Query(value ="call taitucvonlanlai(?1)", nativeQuery = true)
    void Nqtaitucvonlanlai(int stk);
    @Query(value ="call thongkesotientheothang(?1,?2)", nativeQuery = true)
    Float Nqthongkesotientheothang(int thang,int nam);
    @Query(value ="call thongkesotientheoquy(?1,?2)", nativeQuery = true)
    Float Nqthongkesotientheoquy(int quy,int nam);

    @Query(value ="call thongkesotientheonam(?1)", nativeQuery = true)
    Float Nqthongkesotientheonam(int nam);



    @Query(value ="call thongketaikhoanmoitheothang(?1,?2)", nativeQuery = true)
    List<Tktietkiem> Nqthongketaikhoanmoitheothang(int thang, int nam);

    @Query(value = "select *   from tktietkiem where month(ngaymoso)=?1 and year(ngaymoso)=?2",nativeQuery = true)
    List<Tktietkiem>Nqnewusertheothang(int thang, int nam);

    @Query(value ="call thongketaikhoanmoitheoquy(?1,?2)", nativeQuery = true)
    List<Tktietkiem> Nqthongketaikhoanmoitheoquy(int thang, int nam);
    @Query(value ="call thongketaikhoanmoitheonam(?1)", nativeQuery = true)
    List<Tktietkiem> Nqthongketaikhoanmoitheonam(int nam);

}
