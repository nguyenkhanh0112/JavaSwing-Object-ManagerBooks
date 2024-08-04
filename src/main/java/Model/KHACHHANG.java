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
public class KHACHHANG {
    private String MaKH;
    private String HoKH;
    private String TenKH;
    private String SDT;
    private String Email;
    private String Phai;
    private double TongChi;
    private Date NgaySinh;

    public KHACHHANG() {
        
    }

    public KHACHHANG(String MaKH, String HoKH, String TenKH, String SDT, String Email, String Phai, double TongChi, Date NgaySinh) {
        this.MaKH = MaKH;
        this.HoKH = HoKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.Email = Email;
        this.Phai = Phai;
        this.TongChi = TongChi;
        this.NgaySinh = NgaySinh;
    }
    
    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoKH() {
        return HoKH;
    }

    public void setHoKH(String HoKH) {
        this.HoKH = HoKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String Phai) {
        this.Phai = Phai;
    }

    public double getTongChi() {
        return TongChi;
    }

    public void setTongChi(double TongChi) {
        this.TongChi = TongChi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
}
