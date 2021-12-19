package com.nhom8.hethongguitien.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tkkhs",uniqueConstraints = {@UniqueConstraint(columnNames ="username"),
@UniqueConstraint(columnNames = "email")})
public class Tkkh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name="tktietkiem",joinColumns = @JoinColumn(name="id"))
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String tenkh;
    private String cmnd_cccd;
    private String gioitinh;
    private String ngaysinh;
    private String diachi;
    private String sdt;
    private String quoctich;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    public Tkkh(){

    }

//    public Tkkh(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }


    public Tkkh(String username, String email, String password, String cmnd_cccd, String diachi, String gioitinh, String ngaysinh, String quoctich, String sdt, String tenkh) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tenkh = tenkh;
        this.cmnd_cccd = cmnd_cccd;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.quoctich = quoctich;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getCmnd_cccd() {
        return cmnd_cccd;
    }

    public void setCmnd_cccd(String cmnd_cccd) {
        this.cmnd_cccd = cmnd_cccd;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(String quoctich) {
        this.quoctich = quoctich;
    }
}
