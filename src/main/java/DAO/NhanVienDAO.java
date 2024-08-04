/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NHANVIEN;
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
public class NhanVienDAO {
    private ConnectDB_SQLServer _connect = null;
    private  CallableStatement callableStatement = null;
    private PreparedStatement preparedStatement = null;

    public NhanVienDAO() {
        _connect = new ConnectDB_SQLServer();
    }
    public ArrayList<NHANVIEN> selectNVAll(){
        ArrayList<NHANVIEN> staffList = new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            String Query ="{call proc_NHANVIEN_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                NHANVIEN staff = new NHANVIEN();
                staff.setMaNV(resultSet.getString("MaNV"));
                staff.setHoNV(resultSet.getString("HoNV"));
                staff.setTenNV(resultSet.getString("TenNV"));
                staff.setChucVu(resultSet.getString("ChucVu"));
                staff.setEmail(resultSet.getString("Email"));
                staff.setSDT(resultSet.getString("SDT"));
                staff.setLuong(resultSet.getDouble("Luong"));
                staff.setPhai(resultSet.getString("Phai"));
                staff.setNgaySinh(resultSet.getDate("NgaySinh"));
                staffList.add(staff);
            }
        }catch(SQLException ex){
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
        return staffList;
    }
    public ArrayList<NHANVIEN> selectNVByMaNV(){
        ArrayList<NHANVIEN> staffList = new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            String Query ="{call proc_NHANVIEN_select_by_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                NHANVIEN staff = new NHANVIEN();
                staff.setMaNV(resultSet.getString("MaNV"));
                staff.setHoNV(resultSet.getString("HoNV"));
                staff.setTenNV(resultSet.getString("TenNV"));
                staff.setChucVu(resultSet.getString("ChucVu"));
                staff.setEmail(resultSet.getString("Email"));
                staff.setSDT(resultSet.getString("SDT"));
                staff.setLuong(resultSet.getDouble("Luong"));
                staff.setPhai(resultSet.getString("Phai"));
                staff.setNgaySinh(resultSet.getDate("NgaySinh"));
                staffList.add(staff);
            }
        }catch(SQLException ex){
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
        return staffList;
    }
    public int insertNV(String MaNV, String HoNV, String TenNV, String ChucVu, String Email, String SDT, double Luong, String Phai, Date NgaySinh){
        int resultSet =0;
        try{
            Connection connection = _connect.getConnection();
            String Query ="{call proc_NHANVIEN_insert(?,?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaNV);
            callableStatement.setString(2, HoNV);
            callableStatement.setString(3, TenNV);
            callableStatement.setString(4, ChucVu);
            callableStatement.setString(5, Email);
            callableStatement.setString(6, SDT);
            callableStatement.setDouble(7, Luong);
            callableStatement.setString(8, Phai);
            callableStatement.setDate(9, NgaySinh);
            resultSet = callableStatement.executeUpdate();
            
        }catch(SQLException ex){
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
    public int updateNV(String MaNV, String HoNV, String TenNV, String ChucVu, String Email, String SDT, double Luong, String Phai, Date NgaySinh){
        int resultSet =0;
        try{
            Connection connection = _connect.getConnection();
            String Query ="{call proc_NHANVIEN_update(?,?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaNV);
            callableStatement.setString(2, HoNV);
            callableStatement.setString(3, TenNV);
            callableStatement.setString(4, ChucVu);
            callableStatement.setString(5, Email);
            callableStatement.setString(6, SDT);
            callableStatement.setDouble(7, Luong);
            callableStatement.setString(8, Phai);
            callableStatement.setDate(9, NgaySinh);
            resultSet = callableStatement.executeUpdate();
            
        }catch(SQLException ex){
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
    public int deleteNV(String MaNV){
        int resultSet =0;
        try{
            Connection connection = _connect.getConnection();
            String Query ="{call proc_NHANVIEN_delete(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaNV);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException ex){
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
    public ArrayList<NHANVIEN> searchNV_By_Luong(double luong1,double luong2){
        ArrayList<NHANVIEN> listSearch = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_NHANVIEN_search_By_LUONG(?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setDouble(1, luong1);
            callableStatement.setDouble(2, luong2);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                NHANVIEN staff = new NHANVIEN();
                staff.setMaNV(resultSet.getString("MaNV"));
                staff.setHoNV(resultSet.getString("HoNV"));
                staff.setTenNV(resultSet.getString("TenNV"));
                staff.setChucVu(resultSet.getString("ChucVu"));
                staff.setEmail(resultSet.getString("Email"));
                staff.setSDT(resultSet.getString("SDT"));
                staff.setLuong(resultSet.getDouble("Luong"));
                staff.setPhai(resultSet.getString("Phai"));
                staff.setNgaySinh(resultSet.getDate("NgaySinh"));
                listSearch.add(staff);
            }
        }catch(SQLException ex) {
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
        return  listSearch;
    }
    public ArrayList<NHANVIEN> searchStaff(String MaNV, String TenNV, String ChucVu, String LuongTu,String LuongDen, String Phai){
        ArrayList<NHANVIEN> staffsSearch = new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            String Query = "select * from NHANVIEN where 1=1";
            if(MaNV !=null && !MaNV.isEmpty()){
                Query += "and MaNV = ?";
            }
            if(TenNV !=null && !TenNV.isEmpty()){
                Query += "and TenNV like ?";
            }
            if(ChucVu !=null && !ChucVu.isEmpty()){
                Query += "and ChucVu = ?";
            }
            if(LuongTu !=null && !LuongTu.isEmpty()){
                Query += "and Luong >= ?";
            }
            if(LuongDen !=null && !LuongDen.isEmpty()){
                Query += "and Luong <= ?";
            }
            if(Phai !=null && !Phai.isEmpty()){
                Query += "and Phai = ?";
            }
            preparedStatement = connection.prepareStatement(Query);
            int index =1;
            if(MaNV!=null && !MaNV.isEmpty()){
                preparedStatement.setString(index++, MaNV);
            }
            if(TenNV!=null && !TenNV.isEmpty()){
                preparedStatement.setString(index++, TenNV);
            }
            if(ChucVu!=null && !ChucVu.isEmpty()){
                preparedStatement.setString(index++, ChucVu);
            }
            if(LuongTu!=null && !LuongTu.isEmpty()){
                Double luong1 = Double.parseDouble(LuongTu);
                preparedStatement.setDouble(index++,luong1);
            }
            if(LuongDen!=null && !LuongDen.isEmpty()){
                Double luong2 = Double.parseDouble(LuongDen);
                preparedStatement.setDouble(index++,luong2);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                NHANVIEN staff =new NHANVIEN();
                staff.setMaNV(resultSet.getString("MaNV"));
                staff.setHoNV(resultSet.getString("HoNV"));
                staff.setTenNV(resultSet.getString("TenNV"));
                staff.setChucVu(resultSet.getString("ChucVu"));
                staff.setEmail(resultSet.getString("Email"));
                staff.setSDT(resultSet.getString("SDT"));
                staff.setLuong(resultSet.getDouble("Luong"));
                staff.setPhai(resultSet.getString("Phai"));
                staff.setNgaySinh(resultSet.getDate("NgaySinh"));
                staffsSearch.add(staff);
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
            _connect.closeConnection();
        }
        return staffsSearch;
    }
}
