/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Khanh
 */
public class NCC {
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String NguoiLienHe;

    public NCC() {
    }

    public NCC(String MaNCC, String TenNCC, String DiaChi, String SDT, String Email, String NguoiLienHe) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.NguoiLienHe = NguoiLienHe;
    }
    
    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
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

    public String getNguoiLienHe() {
        return NguoiLienHe;
    }

    public void setNguoiLienHe(String NguoiLienHe) {
        this.NguoiLienHe = NguoiLienHe;
    }
    
}
