package com.nhom8.hethongguitien.model;
import com.nhom8.hethongguitien.repository.TkkhRepository;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tktietkiem",uniqueConstraints = {@UniqueConstraint(columnNames ="sotk")})
//@NamedStoredProcedureQuery(name="ruttiendungngaytattoan",procedureName = "ruttiendungngaytattoan",
//parameters = {@StoredProcedureParameter(mode=ParameterMode.IN,name="stk",type = Integer.class),
//@StoredProcedureParameter(mode=ParameterMode.IN,name="stk_thanhtoan",type = Integer.class)})
@NamedStoredProcedureQuery(name = "emp.GetEmpnameAndDept", procedureName = "procmultipleoutputs",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name="thang", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name="nam", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name="id", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name="sotk", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name="tenkh", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name="ngaymoso", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name="sotiengoc", type = Float.class)
        })

public class Tktietkiem {

    @Id
    @GeneratedValue
    private Integer sotk;
//    @ManyToOne
//    @JoinColumn(name="id")
   //
//    private Tkkh tkkh;
    private Integer id;
    private String tenkh;
    private String ngaymoso;
    private String ngaydaohan;
    @GeneratedValue
    private String magd;
    private String loaigd;
    private String phuongthuclanhlai;
    private String phuongthuctaituc;
    private Float sotiengoc;
    private String loaitiente;
    private String makyhan;

    public Tktietkiem() {
    }

    public Tktietkiem(Integer id, String loaigd, String loaitiente,String magd,
                      String makyhan,String phuongthuctaituc,Float sotiengoc,
                      Integer sotk,String tenkh) {
        this.sotk = sotk;
        this.id = id;
        this.tenkh = tenkh;
        this.magd = magd;
        this.loaigd = loaigd;
        this.phuongthuctaituc = phuongthuctaituc;
        this.sotiengoc = sotiengoc;
        this.loaitiente = loaitiente;
        this.makyhan = makyhan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSotk() {
        return sotk;
    }

    public void setSotk(Integer sotk) {
        this.sotk = sotk;
    }



    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getNgaymoso() {
        return ngaymoso;
    }

    public void setNgaymoso(String ngaymoso) {
        this.ngaymoso = ngaymoso;
    }

    public String getNgaydaohan() {
        return ngaydaohan;
    }

    public void setNgaydaohan(String ngaydaohan) {
        this.ngaydaohan = ngaydaohan;
    }

    public String getMagd() {
        return magd;
    }

    public void setMagd(String magd) {
        this.magd = magd;
    }

    public String getLoaigd() {
        return loaigd;
    }

    public void setLoaigd(String loaigd) {
        this.loaigd = loaigd;
    }

    public String getPhuongthuclanhlai() {
        return phuongthuclanhlai;
    }

    public void setPhuongthuclanhlai(String phuongthuclanhlai) {
        this.phuongthuclanhlai = phuongthuclanhlai;
    }

    public String getPhuongthuctaituc() {
        return phuongthuctaituc;
    }

    public void setPhuongthuctaituc(String phuongthuctaituc) {
        this.phuongthuctaituc = phuongthuctaituc;
    }

    public Float getSotiengoc() {
        return sotiengoc;
    }

    public void setSotiengoc(Float sotiengoc) {
        this.sotiengoc = sotiengoc;
    }

    public String getLoaitiente() {
        return loaitiente;
    }

    public void setLoaitiente(String loaitiente) {
        this.loaitiente = loaitiente;
    }

    public String getMakyhan() {
        return makyhan;
    }

    public void setMakyhan(String makyhan) {
        this.makyhan = makyhan;
    }

//    public Tkkh getTkkh() {
//        return tkkh;
//    }
//
//    public void setTkkh(Tkkh tkkh) {
//        this.tkkh = tkkh;
//    }
}
