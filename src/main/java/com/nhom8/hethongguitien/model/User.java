//package com.nhom8.hethongguitien.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "khachhangcn")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String tenkh;
//    private String cmnd_cccd;
//    private String gioitinh;
//    private String ngaysinh;
//    private String diachi;
//    private String sdt;
//    private String quoctich;
//    private String emailkh;
//
//    public User(int id, String tenkh, String cmnd_cccd, String gioitinh, String ngaysinh, String diachi, String sdt, String quoctich, String emailkh) {
//        this.id = id;
//        this.tenkh = tenkh;
//        this.cmnd_cccd = cmnd_cccd;
//        this.gioitinh = gioitinh;
//        this.ngaysinh = ngaysinh;
//        this.diachi = diachi;
//        this.sdt = sdt;
//        this.quoctich = quoctich;
//        this.emailkh = emailkh;
//    }
//
//    public User() {
//
//    }
//
////    public User(String TenKH, String CMND_CCCD, String GioiTinh, String NgaySinh, String DiaChi, String SDT, String QuocTich, String EmailKH) {
////        super();
////        this.TenKH=TenKH;
////        this.CMND_CCCD=CMND_CCCD;
////        this.GioiTinh=GioiTinh;
////        this.NgaySinh=NgaySinh;
////        this.DiaChi=DiaChi;
////        this.SDT=SDT;
////        this.QuocTich=QuocTich;
////        this.EmailKH=EmailKH;
////    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTenkh() {
//        return tenkh;
//    }
//
//    public void setTenkh(String tenkh) {
//        this.tenkh = tenkh;
//    }
//
//    public String getCmnd_cccd() {
//        return cmnd_cccd;
//    }
//
//    public void setCmnd_cccd(String cmnd_cccd) {
//        this.cmnd_cccd = cmnd_cccd;
//    }
//
//    public String getGioitinh() {
//        return gioitinh;
//    }
//
//    public void setGioitinh(String gioitinh) {
//        this.gioitinh = gioitinh;
//    }
//
//    public String getNgaysinh() {
//        return ngaysinh;
//    }
//
//    public void setNgaysinh(String ngaysinh) {
//        this.ngaysinh = ngaysinh;
//    }
//
//    public String getDiachi() {
//        return diachi;
//    }
//
//    public void setDiachi(String diachi) {
//        this.diachi = diachi;
//    }
//
//    public String getSdt() {
//        return sdt;
//    }
//
//    public void setSdt(String sdt) {
//        this.sdt = sdt;
//    }
//
//    public String getQuoctich() {
//        return quoctich;
//    }
//
//    public void setQuoctich(String quoctich) {
//        this.quoctich = quoctich;
//    }
//
//    public String getEmailkh() {
//        return emailkh;
//    }
//
//    public void setEmailkh(String emailkh) {
//        this.emailkh = emailkh;
//    }
//}