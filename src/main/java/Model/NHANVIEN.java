/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Nguyen Khanh
 */
public class NHANVIEN {
    private String MaNV;
    private String HoNV;
    private String TenNV;
    private String ChucVu;
    private String Email;
    private String SDT;
    private double Luong;
    private String Phai;
    private Date NgaySinh;

    public NHANVIEN() {
    }
    
    public NHANVIEN(String MaNV, String HoNV, String TenNV, String ChucVu, String Email, String SDT, double Luong, String Phai, Date NgaySinh) {
        this.MaNV = MaNV;
        this.HoNV = HoNV;
        this.TenNV = TenNV;
        this.ChucVu = ChucVu;
        this.Email = Email;
        this.SDT = SDT;
        this.Luong = Luong;
        this.Phai = Phai;
        this.NgaySinh = NgaySinh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoNV() {
        return HoNV;
    }

    public void setHoNV(String HoNV) {
        this.HoNV = HoNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String Phai) {
        this.Phai = Phai;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
}
