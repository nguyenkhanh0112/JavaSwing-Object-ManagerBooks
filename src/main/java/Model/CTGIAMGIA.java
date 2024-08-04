/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nguyen Khanh
 */
public class CTGIAMGIA {
    private String MaGG;
    private String MaSach;
    private double PhanTramGG;

    public CTGIAMGIA() {
    }

    public CTGIAMGIA(String MaGG, String MaSach, double PhanTramGG) {
        this.MaGG = MaGG;
        this.MaSach = MaSach;
        this.PhanTramGG = PhanTramGG;
    }
    
    public String getMaGG() {
        return MaGG;
    }

    public void setMaGG(String MaGG) {
        this.MaGG = MaGG;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public double getPhanTramGG() {
        return PhanTramGG;
    }

    public void setPhanTramGG(double PhanTramGG) {
        this.PhanTramGG = PhanTramGG;
    }
    
}
