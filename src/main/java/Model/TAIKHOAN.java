/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author Nguyen Khanh
 */
public class TAIKHOAN {
    private String MaTK;
    private String TenTK;
    private String MATKHAU;
    private int TrangThaiString;
    private String Quyen;
    
    

    public TAIKHOAN(String MaTK, String TenTK, String MATKHAU, int TrangThaiString, String Quyen) {
        this.MaTK = MaTK;
        this.TenTK = TenTK;
        this.MATKHAU = MATKHAU;
        this.TrangThaiString = TrangThaiString;
        this.Quyen = Quyen;
    }

    public TAIKHOAN(String TenTK, String MATKHAU) {
        this.TenTK = TenTK;
        this.MATKHAU = MATKHAU;
    }
    public TAIKHOAN() {
    }
    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public int getTrangThaiString() {
        return TrangThaiString;
    }

    public void setTrangThaiString(int TrangThaiString) {
        this.TrangThaiString = TrangThaiString;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }
    
}
