package com.nhom8.hethongguitien.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "tkthanhtoan",uniqueConstraints = {@UniqueConstraint(columnNames ="sotk")})
public class Tkthanhtoan {
    @Id
    @GeneratedValue
    private Integer sotk;

    private Integer id;
    private String tenkh;
    private Float sodudauky;
    private Float soducuoiky;

    private String loaigd;
    private Float sotien;
    private String loaitiente;
    private String makyhan;

    public Tkthanhtoan() {
    }

    public Tkthanhtoan( Integer id,String loaigd,String loaitiente,String makyhan,Float soducuoiky,Float sodudauky,Float sotien,Integer sotk, String tenkh) {
        this.sotk = sotk;
        this.id = id;
        this.tenkh = tenkh;
        this.sodudauky = sodudauky;
        this.soducuoiky = soducuoiky;
        this.loaigd = loaigd;
        this.sotien = sotien;
        this.loaitiente = loaitiente;
        this.makyhan = makyhan;
    }

    public Integer getSotk() {
        return sotk;
    }

    public void setSotk(Integer sotk) {
        this.sotk = sotk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public Float getSodudauky() {
        return sodudauky;
    }

    public void setSodudauky(Float sodudauky) {
        this.sodudauky = sodudauky;
    }

    public Float getSoducuoiky() {
        return soducuoiky;
    }

    public void setSoducuoiky(Float soducuoiky) {
        this.soducuoiky = soducuoiky;
    }

    public String getLoaigd() {
        return loaigd;
    }

    public void setLoaigd(String loaigd) {
        this.loaigd = loaigd;
    }

    public Float getSotien() {
        return sotien;
    }

    public void setSotien(Float sotien) {
        this.sotien = sotien;
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
}
