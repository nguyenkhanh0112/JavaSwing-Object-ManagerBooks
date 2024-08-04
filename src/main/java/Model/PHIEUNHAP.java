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
public class PHIEUNHAP {
    private String MaPN;
    private String MaNV;
    private String MaNCC;
    private int TrangThai;
    private double TongTien;
    private Date NgayNhap;

    public PHIEUNHAP(String MaPN, String MaNV, String MaNCC, int TrangThai, double TongTien, Date NgayNhap) {
        this.MaPN = MaPN;
        this.MaNV = MaNV;
        this.MaNCC = MaNCC;
        this.TrangThai = TrangThai;
        this.TongTien = TongTien;
        this.NgayNhap = NgayNhap;
    }

    public PHIEUNHAP() {
    }
    
    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }
    
    
}
