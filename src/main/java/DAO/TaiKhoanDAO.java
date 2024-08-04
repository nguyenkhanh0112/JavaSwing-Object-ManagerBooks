/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.TAIKHOAN;
import _Connection.ConnectDB_SQLServer;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author Nguyen Khanh
 */
public class TaiKhoanDAO {
    private ConnectDB_SQLServer _connect=null;
    private  CallableStatement callableStatement=null;
    public TaiKhoanDAO(){
        _connect = new ConnectDB_SQLServer();
    }
    public boolean authenticate(String usernameString,String Matkhau){
        boolean isValid = false;
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_TAIKHOAN_check_TKMK(?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, usernameString);
            callableStatement.setString(2, Matkhau);
            ResultSet resultSet = callableStatement.executeQuery();
            if(resultSet.next()){
                isValid = true;
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
        return isValid;
    }
    @SuppressWarnings("empty-statement")
    public ArrayList<TAIKHOAN> loadingTaiKhoan(){
        ArrayList<TAIKHOAN> taikhoanlist = new  ArrayList<>();
//        Connection connection = _connect.getConnection();
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_TAIKHOAN_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                TAIKHOAN taiKhoan = new TAIKHOAN();
                taiKhoan.setMaTK(resultSet.getString("MaTK"));
                taiKhoan.setTenTK(resultSet.getString("TenTK"));
                taiKhoan.setMATKHAU(resultSet.getString("MATKHAU"));
                taiKhoan.setQuyen(resultSet.getString("Quyen"));
                taiKhoan.setTrangThaiString(resultSet.getInt("TrangThai"));
                taikhoanlist.add(taiKhoan);
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
        return taikhoanlist;
    }
    public int insertTaiKhoang(String MaTK,String TenTK, String MatKhau, String Quyen, int TrangThai){
        int resultSet = 0;
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_TAIKOAN_insert(?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1,MaTK);
            callableStatement.setString(2,TenTK);
            callableStatement.setString(3,MatKhau);
            callableStatement.setString(4,Quyen);
            callableStatement.setInt(5, TrangThai);
            resultSet = callableStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
            
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
    public int updateTaikhoan(String MaTK,String TenTK, String MatKhau, String Quyen, int TrangThai){
        int resultSet = 0;
        try{
            Connection connection =_connect.getConnection();
            String Query ="{call proc_TAIKHOAN_update(?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1,MaTK);
            callableStatement.setString(2,TenTK);
            callableStatement.setString(3,MatKhau);
            callableStatement.setString(4,Quyen);
            callableStatement.setInt(5,TrangThai);
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
    public int deleteTaiKhoan(String MaTK){
        int resultSet = 0;
        try{
            Connection connection =_connect.getConnection();
            String Query = "{call proc_TAIKHOANG_delete_by_MaTK(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString("MaTK", MaTK);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            _connect.closeConnection();
        }
        return resultSet;
    }
}
