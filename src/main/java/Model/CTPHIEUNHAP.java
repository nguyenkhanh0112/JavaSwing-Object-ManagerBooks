/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Khanh
 */
public class CTPHIEUNHAP {
    private String MaCTPN;
    private String MaPN;
    private String MaSach;
    private double DonGia;
    private int SoLuong;
    private double ThanhTien;

    public CTPHIEUNHAP() {
    }

    public CTPHIEUNHAP(String MaCTPN, String MaPN, String MaSach, double DonGia, int SoLuong, double ThanhTien) {
        this.MaCTPN = MaCTPN;
        this.MaPN = MaPN;
        this.MaSach = MaSach;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }
    
    public String getMaCTPN() {
        return MaCTPN;
    }

    public void setMaCTPN(String MaCTPN) {
        this.MaCTPN = MaCTPN;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
