/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.KHACHHANG;
import _Connection.ConnectDB_SQLServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khanh
 */
public class KhachHangDAO {
    private ConnectDB_SQLServer _Connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement preparedStatement=null;

    public KhachHangDAO() {
        _Connect = new ConnectDB_SQLServer();
    }
    public ArrayList<KHACHHANG> selectKHAll(){
        ArrayList<KHACHHANG> clientList = new ArrayList<>();
        try {
            Connection connection = _Connect.getConnection();
            String Query = "{call proc_KHACHHANG_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                KHACHHANG client = new KHACHHANG();
                client.setMaKH(resultSet.getString("MaKH"));
                client.setHoKH(resultSet.getString("HoKH"));
                client.setTenKH(resultSet.getString("TenKH"));
                client.setSDT(resultSet.getString("SDT"));
                client.setEmail(resultSet.getString("Email"));
                client.setPhai(resultSet.getString("Phai"));
                client.setTongChi(resultSet.getDouble("TongChi"));
                client.setNgaySinh(resultSet.getDate("NgaySinh"));
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return clientList;
    }
     public ArrayList<KHACHHANG> selectKH_By_MaKH(String MaKH){
        ArrayList<KHACHHANG> clientList = new ArrayList<>();
        try {
            Connection connection = _Connect.getConnection();
            String Query = "{call proc_KHACHHANG_select_by_MaKH(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaKH);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                KHACHHANG client = new KHACHHANG();
                client.setMaKH(resultSet.getString("MaKH"));
                client.setHoKH(resultSet.getString("HoKH"));
                client.setTenKH(resultSet.getString("TenKH"));
                client.setSDT(resultSet.getString("SDT"));
                client.setEmail(resultSet.getString("Email"));
                client.setPhai(resultSet.getString("Phai"));
                client.setTongChi(resultSet.getDouble("TongChi"));
                client.setNgaySinh(resultSet.getDate("NgaySinh"));
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return clientList;
    }
    public int insertKH(String MaKH, String HoKH, String TenKH, String SDT, String Email, String Phai, double TongChi, Date NgaySinh){
        int resultSet = 0;
        try {
            Connection connection = _Connect.getConnection();
            String Query = "{Call proc_KHACHHANG_insert(?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaKH);
            callableStatement.setString(2, HoKH);
            callableStatement.setString(3, TenKH);
            callableStatement.setString(4, SDT);
            callableStatement.setString(5, Email);
            callableStatement.setString(6, Phai);
            callableStatement.setDouble(7, TongChi);
            callableStatement.setDate(8, NgaySinh);
            resultSet = callableStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
             if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return resultSet;
    }
    public int updateKH(String MaKH, String HoKH, String TenKH, String SDT, String Email, String Phai, double TongChi, Date NgaySinh){
         int resultSet = 0;
        try {
            Connection connection = _Connect.getConnection();
            String Query = "{Call proc_KHACHHANG_update(?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaKH);
            callableStatement.setString(2, HoKH);
            callableStatement.setString(3, TenKH);
            callableStatement.setString(4, SDT);
            callableStatement.setString(5, Email);
            callableStatement.setString(6, Phai);
            callableStatement.setDouble(7, TongChi);
            callableStatement.setDate(8, NgaySinh);
            resultSet = callableStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
             if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return resultSet;
    }
    public int deleteKH(String MaKH){
        int resultSet = 0;
        try {
            Connection connection = _Connect.getConnection();
            String Query = "{Call proc_KHACHHANG_delete(?)}";
            callableStatement = connection.prepareCall(Query);
            resultSet = callableStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return resultSet;
    }
    public int updateTongChi(String MaKH,double TongTien){
        int resultSet =0;
        try{
            Connection connection = _Connect.getConnection();
            String Query = "update KHACHHANG set TongChi = ? where MaKH = ?";
            preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setDouble(1, TongTien);
            preparedStatement.setString(2, MaKH);
            resultSet = preparedStatement.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
             if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return resultSet;
    }
    public ArrayList<KHACHHANG> searchClients(String MaKH, String TenKH, String TongChiTu,String TongChiDen, String Phai){
        ArrayList<KHACHHANG> clients = new ArrayList<>();
        try{
            Connection connection = _Connect.getConnection();
            String Query = "select * from KHACHHANG where 1=1";
            if(MaKH !=null && !MaKH.isEmpty()){
                Query += "and MaKH = ?";
            }
            if(TenKH !=null && !TenKH.isEmpty()){
                Query += "and TenKH like ?";
            }
            if(TongChiTu !=null && !TongChiDen.isEmpty()){
                Query += "and TongChi >= ?";
            }
            if(TongChiDen !=null && !TongChiDen.isEmpty()){
                Query += "and TongChi <= ?";
            }
            if(Phai !=null && !Phai.isEmpty()){
                Query += "and Phai = ?";
            }
            preparedStatement = connection.prepareCall(Query);
            int index =1;
            if(MaKH!=null && !MaKH.isEmpty()){
                preparedStatement.setString(index++, MaKH);
            }
            if(TenKH!=null && !TenKH.isEmpty()){
                preparedStatement.setString(index++, TenKH);
            }
            if(TongChiTu!=null && !TongChiTu.isEmpty()){
                Double tongchi = Double.parseDouble(TongChiTu);
                preparedStatement.setDouble(index++,tongchi);
            }
            if(TongChiDen!=null && !TongChiDen.isEmpty()){
                Double tongchi = Double.parseDouble(TongChiDen);
                preparedStatement.setDouble(index++,tongchi);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                KHACHHANG client =new KHACHHANG();
                client.setMaKH(resultSet.getString("MaKH"));
                client.setHoKH(resultSet.getString("HoKH"));
                client.setTenKH(resultSet.getString("TenKH"));
                client.setSDT(resultSet.getString("SDT"));
                client.setEmail(resultSet.getString("Email"));
                client.setPhai(resultSet.getString("Phai"));
                client.setTongChi(resultSet.getDouble("TongChi"));
                client.setNgaySinh(resultSet.getDate("NgaySinh"));
                clients.add(client);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            _Connect.closeConnection();
        }
        return clients;
    }
    public int countNumbersKH(){
        ResultSet resultSet = null;
        int count =0;
        try{
            Connection connection = _Connect.getConnection();
            String Query ="select COUNT(MaKH) from KHACHHANG";
            preparedStatement = connection.prepareStatement(Query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
                
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }  
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
