/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CTHOADON;
import _Connection.ConnectDB_SQLServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khanh
 */
public class ChiTietHoaDonDAO {
    private _Connection.ConnectDB_SQLServer _connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement preparedStatement = null;
    public ChiTietHoaDonDAO() {
        _connect = new ConnectDB_SQLServer();
    }
    public ArrayList<CTHOADON> selectAll(){
        ArrayList<CTHOADON> detailBillList = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{Call proc_CHITIETHOADON_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                CTHOADON detailBill = new CTHOADON();
                detailBill.setMaHD(resultSet.getString("MaHD"));
                detailBill.setMaSach(resultSet.getString("MaSach"));
                detailBill.setTenSach(resultSet.getString("TenSach"));
                detailBill.setSoLuong(resultSet.getInt("Soluong"));
                detailBill.setDonGia(resultSet.getDouble("DonGia"));
                detailBill.setGiamGia(resultSet.getDouble("GiamGia"));
                detailBill.setThanhTien(resultSet.getDouble("ThanhTien"));
                detailBillList.add(detailBill);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
             if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return  detailBillList;
    }
       public ArrayList<CTHOADON> selectByMaHD(String MaHD){
        ArrayList<CTHOADON> detailBillList = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{Call proc_CHITIETHOADON_select_by_MaHD(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaHD);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                CTHOADON detailBill = new CTHOADON();
                detailBill.setMaHD(resultSet.getString("MaHD"));
                detailBill.setMaSach(resultSet.getString("MaSach"));
                detailBill.setTenSach(resultSet.getString("TenSach"));
                detailBill.setSoLuong(resultSet.getInt("Soluong"));
                detailBill.setDonGia(resultSet.getDouble("DonGia"));
                detailBill.setGiamGia(resultSet.getDouble("GiamGia"));
                detailBill.setThanhTien(resultSet.getDouble("ThanhTien"));
                detailBillList.add(detailBill);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
             if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return  detailBillList;
    }
       public int insertCTHOADON(String MaHD, String MaSach, String TenSach, int SoLuong, double DonGia, double GiamGia, double ThanhTien){
           int resultSet =0;
           try {
               Connection connection = _connect.getConnection();
               String Query = "{call proc_CHITIETHOADON_insert (?,?,?,?,?,?,?)}";
               callableStatement = connection.prepareCall(Query);
               callableStatement.setString(1, MaHD);
               callableStatement.setString(2, MaSach);
               callableStatement.setString(3, TenSach);
               callableStatement.setInt(4, SoLuong);
               callableStatement.setDouble(5, DonGia);
               callableStatement.setDouble(6, GiamGia);
               callableStatement.setDouble(7, ThanhTien);
               resultSet =callableStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           } finally {
                if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    }
                }
           }
           return resultSet;
       }
    
       public int updateCTHOADON(String MaHD, String MaSach, String TenSach, int SoLuong, double DonGia, double GiamGia, double ThanhTien){
           int resultSet =0;
           try {
               Connection connection = _connect.getConnection();
               String Query = "{call proc_CHITIETHOADON_update (?,?,?,?,?,?,?)}";
               callableStatement = connection.prepareCall(Query);
               callableStatement.setString(1, MaHD);
               callableStatement.setString(2, MaSach);
               callableStatement.setString(3, TenSach);
               callableStatement.setInt(4, SoLuong);
               callableStatement.setDouble(5, DonGia);
               callableStatement.setDouble(6, GiamGia);
               callableStatement.setDouble(7, ThanhTien);
               resultSet = callableStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           } finally {
                if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    }
                }
           }
           return resultSet;
       }
    
        public int deleteCTHOADON(String MaHD,String MaSach){
           int resultSet =0;
           try {
               Connection connection = _connect.getConnection();
               String Query = "{call proc_CHITIETHOADON_delete (?,?)}";
               callableStatement = connection.prepareCall(Query);
               callableStatement.setString(1, MaHD);
               callableStatement.setString(2, MaSach);
               resultSet = callableStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           } finally {
                if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
           return resultSet;
    }
    public ArrayList<CTHOADON> select_CTHD_byMaHD(String MaHD){
        ArrayList<CTHOADON> cthoadons = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "select * from CHITIETHOADON where 1=1 ";
            if(MaHD!=null &&!MaHD.isEmpty()){
                Query+= "and MaHD = ? ";
            }
            preparedStatement = connection.prepareStatement(Query);
            if(MaHD!=null&&!MaHD.isEmpty()){
                preparedStatement.setString(1, MaHD);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                CTHOADON cthoadon = new CTHOADON();
                cthoadon.setMaHD(resultSet.getString("MaHD"));
                cthoadon.setMaSach(resultSet.getString("MaSach"));
                cthoadon.setTenSach(resultSet.getString("TenSach"));
                cthoadon.setSoLuong(resultSet.getInt("Soluong"));
                cthoadon.setDonGia(resultSet.getDouble("DonGia"));
                cthoadon.setGiamGia(resultSet.getDouble("GiamGia"));
                cthoadon.setThanhTien(resultSet.getDouble("ThanhTien"));
                cthoadons.add(cthoadon);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                _connect.closeConnection();
        }
        return cthoadons;
    }
}
