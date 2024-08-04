/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.net.Socket;

/**
 *
 * @author Nguyen Khanh
 */
public class CTHOADON {
    private String MaHD;
    private String MaSach;
    private String TenSach;
    private int SoLuong;
    private double DonGia;
    private double GiamGia;
    private double ThanhTien;

    public CTHOADON(String MaHD, String MaSach, String TenSach, int SoLuong, double DonGia, double GiamGia, double ThanhTien) {
        this.MaHD = MaHD;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
        this.ThanhTien = ThanhTien;
    }
    
    public CTHOADON() {
    }
    public double getPhanTramGG(double sotiengiamgia,double dongia){
        return (sotiengiamgia*100)/dongia;
    }
    public double Thanhtien(int soluong,double dongia,double sotiengg){
        return soluong*(dongia-sotiengg);
    }
    public double getSotienGG(double phantramgg,double dongia){
        return (phantramgg*dongia)/100;
    }
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
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
