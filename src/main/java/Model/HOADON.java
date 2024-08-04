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
public class HOADON {
    private String MaHD;
    private String MaKH;
    private String MaNV;
    private String MaGG;
    private Date NgayLapDate;
    private double GiamGia;
    private double ThanhTien;
    private double TongTien;

    public HOADON() {
    }

    public HOADON(String MaHD, String MaKH, String MaNV, String MaGG, Date NgayLapDate,double TongTien, double GiamGia, double ThanhTien) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.MaGG = MaGG;
        this.NgayLapDate = NgayLapDate;
        this.GiamGia = GiamGia;
        this.TongTien =TongTien;
        this.ThanhTien = ThanhTien;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaGG() {
        return MaGG;
    }

    public void setMaGG(String MaGG) {
        this.MaGG = MaGG;
    }

    public Date getNgayLapDate() {
        return NgayLapDate;
    }

    public void setNgayLapDate(Date NgayLapDate) {
        this.NgayLapDate = NgayLapDate;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(double GiamGia) {
        this.GiamGia = GiamGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
