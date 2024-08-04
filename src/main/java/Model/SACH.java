/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Khanh
 */
public class SACH {
    private String MaSach;
    private String MaNXB;
    private String MaTL;
    private String MaTG;
    private String TenSach;
    private int NamXB;
    private int SoLuong;
    private double DonGia;
    private String HinhAnh;

    public SACH(String MaSach, String MaNXB, String MaTL, String MaTG, String TenSach, int NamXB, int SoLuong, double DonGia,String HinhAnh) {
        this.MaSach = MaSach;
        this.MaNXB = MaNXB;
        this.MaTL = MaTL;
        this.MaTG = MaTG;
        this.TenSach = TenSach;
        this.NamXB = NamXB;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.HinhAnh = HinhAnh;
    }

    public SACH() {
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
    
    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getNamXB() {
        return NamXB;
    }

    public void setNamXB(int NamXB) {
        this.NamXB = NamXB;
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
    
}
