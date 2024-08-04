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
public class GIAMGIA {
    private String MaGG;
    private String TenCT;
    private String LoaiCT;
    private Date NgayBD;
    private Date NgayKT;
    private Double PhanTramGG;

    public GIAMGIA() {
    }

    public GIAMGIA(String MaGG, String TenCT, String LoaiCT, Date NgayBD, Date NgayKT,Double PhanTramGG) {
        this.MaGG = MaGG;
        this.TenCT = TenCT;
        this.LoaiCT = LoaiCT;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.PhanTramGG = PhanTramGG;
    }

    public Double getPhanTramGG() {
        return PhanTramGG;
    }

    public void setPhanTramGG(Double PhanTramGG) {
        this.PhanTramGG = PhanTramGG;
    }
    
    public String getMaGG() {
        return MaGG;
    }

    public void setMaGG(String MaGG) {
        this.MaGG = MaGG;
    }

    public String getTenCT() {
        return TenCT;
    }

    public void setTenCT(String TenCT) {
        this.TenCT = TenCT;
    }

    public String getLoaiCT() {
        return LoaiCT;
    }

    public void setLoaiCT(String LoaiCT) {
        this.LoaiCT = LoaiCT;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }
    
}
