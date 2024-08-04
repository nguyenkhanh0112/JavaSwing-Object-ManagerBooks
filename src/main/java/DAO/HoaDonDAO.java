/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.HOADON;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.ss.formula.functions.Count;

/**
 *
 * @author Nguyen Khanh
 */
public class HoaDonDAO {
    private CallableStatement callableStatement=null;
    private _Connection.ConnectDB_SQLServer _connect=null;
    private PreparedStatement preparedStatement=null;
    

    public HoaDonDAO() {
        _connect = new _Connection.ConnectDB_SQLServer();
    }
    public ArrayList<HOADON> selectALL(){
        ArrayList<HOADON> listBill = new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_HOADON_select_all}";;
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                HOADON bill = new HOADON();
                bill.setMaHD(resultSet.getString("MaHD"));
                bill.setMaKH(resultSet.getString("MaKH"));
                bill.setMaNV(resultSet.getString("MaNV"));
                bill.setMaGG(resultSet.getString("MaGG"));
                bill.setNgayLapDate(resultSet.getDate("NgayLap"));
                bill.setTongTien(resultSet.getDouble("TongTien"));
                bill.setGiamGia(resultSet.getDouble("GiamGia"));
                bill.setThanhTien(resultSet.getDouble("ThanhTien"));
                listBill.add(bill);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
               if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _connect.closeConnection();
        }
        return listBill;
    }
    public ArrayList<HOADON> selectByMaHD(String MaHD){
        ArrayList<HOADON> listBill = new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_HOADON_select_by_MaHD(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaHD);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                HOADON bill = new HOADON();
                bill.setMaHD(resultSet.getString("MaHD"));
                bill.setMaKH(resultSet.getString("MaKH"));
                bill.setMaNV(resultSet.getString("MaNV"));
                bill.setMaGG(resultSet.getString("MaGG"));
                bill.setNgayLapDate(resultSet.getDate("NgayLap"));
                bill.setTongTien(resultSet.getDouble("TongTien"));
                bill.setGiamGia(resultSet.getDouble("GiamGia"));
                bill.setThanhTien(resultSet.getDouble("ThanhTien"));
                listBill.add(bill);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
               if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _connect.closeConnection();
        }
        return listBill;
    }
    public int insertHD(String MaHD, String MaKH, String MaNV, String MaGG, Date NgayLapDate,double TongTien ,double GiamGia, double ThanhTien){
        int resultSet = 0;
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_HOADON_insert(?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaHD);
            callableStatement.setString(2, MaKH);
            callableStatement.setString(3, MaNV);
            callableStatement.setString(4, MaGG);
            callableStatement.setDate(5, NgayLapDate);
            callableStatement.setDouble(6, TongTien);
            callableStatement.setDouble(7, GiamGia);
            callableStatement.setDouble(8, ThanhTien);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
              if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _connect.closeConnection();
        }
        return resultSet;
    }
    public int updateHD(String MaHD, String MaKH, String MaNV, String MaGG, Date NgayLapDate,double TongTien ,double GiamGia, double ThanhTien){
        int resultSet = 0;
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_HOADON_update(?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaHD);
            callableStatement.setString(2, MaKH);
            callableStatement.setString(3, MaNV);
            callableStatement.setString(4, MaGG);
            callableStatement.setDate(5, NgayLapDate);
            callableStatement.setDouble(6, TongTien);
            callableStatement.setDouble(7, GiamGia);
            callableStatement.setDouble(8, ThanhTien);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
              if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _connect.closeConnection();
        }
        return resultSet;
    }
     public int deleteHD(String MaHD){
        int resultSet = 0;
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_HOADON_delete(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaHD);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _connect.closeConnection();
        }
        return resultSet;
    }
    public int countNumbers(){
        int count =0;
        try{
            Connection connection = _connect.getConnection();
            String Query = "select Count(HOADON.MaHD) from HOADON";
            preparedStatement = connection.prepareStatement(Query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _connect.closeConnection();
        }
        return count;
    }
    public ArrayList<HOADON> searchHD(String MaHD,String MaKH,String MaNV,java.util.Date thoigiantu,java.util.Date thoigianden,String giatientuString,String giatienden){
        ArrayList<HOADON> hoadons = new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            String Query = "select * from HOADON where 1=1";
            if(MaHD!=null&&!MaHD.isEmpty()){
                Query+="and MaHD like ? ";
            }
            if(MaKH!=null&&!MaKH.isEmpty()){
                Query+="and MaKH like ? ";
            }
            if(MaNV!=null && !MaNV.isEmpty()){
                Query+="and MaNV like ? ";
            }
            if(thoigiantu!=null){
                Query+="and NgayLap >= ? ";
            }
            if(thoigianden!=null){
                Query+="and NgayLap <= ? ";
            }
            if(giatientuString!=null && !giatientuString.isEmpty()){
                Query+="and ThanhTien >= ? ";
            }
            if(giatienden!=null && !giatienden.isEmpty()){
                Query+="and ThanhTien <= ? ";
            }
            preparedStatement = connection.prepareStatement(Query);
            int index = 1;
            if(MaHD!=null&&!MaHD.isEmpty()){
               preparedStatement.setString(index++,"%" + MaHD + "%");
            }
            if(MaKH!=null&&!MaKH.isEmpty()){
               preparedStatement.setString(index++,"%" + MaKH + "%");
            }
            if(MaNV!=null && !MaNV.isEmpty()){
                preparedStatement.setString(index++,"%" + MaNV + "%");
            }
            if(thoigiantu!=null){
                java.sql.Date sqlNgayBD = new java.sql.Date(thoigiantu.getTime());
                preparedStatement.setDate(index++, sqlNgayBD);
            }
            if(thoigianden!=null){
                java.sql.Date sqlNgayBD = new java.sql.Date(thoigianden.getTime());
                preparedStatement.setDate(index++, sqlNgayBD);
            }
            if(giatientuString!=null && !giatientuString.isEmpty()){
                Double giatientu = Double.parseDouble(giatientuString);
                preparedStatement.setDouble(index++, giatientu);
            }
            if(giatienden!=null && !giatienden.isEmpty()){
                Double giatienden1 = Double.parseDouble(giatienden);
                preparedStatement.setDouble(index++, giatienden1);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                HOADON hoadon = new HOADON();
                hoadon.setMaHD(resultSet.getString("MaHD"));
                hoadon.setMaKH(resultSet.getString("MaKH"));
                hoadon.setMaNV(resultSet.getString("MaNV"));
                hoadon.setMaGG(resultSet.getString("MaGG"));
                hoadon.setNgayLapDate(resultSet.getDate("NgayLap"));
                hoadon.setTongTien(resultSet.getDouble("TongTien"));
                hoadon.setGiamGia(resultSet.getDouble("GiamGia"));
                hoadon.setThanhTien(resultSet.getDouble("ThanhTien"));
                hoadons.add(hoadon);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _connect.closeConnection();
        }
        return hoadons;
    }
}
