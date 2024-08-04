/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CTPHIEUNHAP;
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
public class CTPhieuNhapDAO {
    private _Connection.ConnectDB_SQLServer _connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement preparedStatement = null;

    public CTPhieuNhapDAO() {
        _connect = new ConnectDB_SQLServer();
    }
    public ArrayList<CTPHIEUNHAP> selectAll(){
        ArrayList<CTPHIEUNHAP> arrayList = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITIETPHIEUNHAP_select_all }";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                CTPHIEUNHAP ctphieunhap = new CTPHIEUNHAP();
                ctphieunhap.setMaCTPN(resultSet.getString("MaCTPN"));
                ctphieunhap.setMaPN(resultSet.getString("MaPN"));
                ctphieunhap.setMaSach(resultSet.getString("MaSach"));
                ctphieunhap.setDonGia(resultSet.getDouble("DonGia"));
                ctphieunhap.setSoLuong(resultSet.getInt("Soluong"));
                ctphieunhap.setThanhTien(resultSet.getDouble("ThanhTien"));
                arrayList.add(ctphieunhap);
            }
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
            _connect.closeConnection();
        }
        return arrayList;
    }
    public int insertCTPN(String MaCTPN, String MaPN, String MaSach, double DonGia, int SoLuong, double ThanhTien){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITIETPHIEUNHAP_insert(?,?,?,?,?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaCTPN);
            callableStatement.setString(2, MaPN);
            callableStatement.setString(3, MaSach);
            callableStatement.setDouble(4, DonGia);
            callableStatement.setInt(5, SoLuong);
            callableStatement.setDouble(6, ThanhTien);
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
            _connect.closeConnection();            
        }
        return resultSet;
    }
    public int updateCTPN(String MaCTPN, String MaPN, String MaSach, double DonGia, int SoLuong, double ThanhTien){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call  proc_CHITIETPHIEUNHAP_update (?,?,?,?,?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaCTPN);
            callableStatement.setString(2, MaPN);
            callableStatement.setString(3, MaSach);
            callableStatement.setDouble(4, DonGia);
            callableStatement.setInt(5, SoLuong);
            callableStatement.setDouble(6, ThanhTien);
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
            _connect.closeConnection();            
        }
        return resultSet;
    }
     public int deleteCTPN(String MaCTPN){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITIETPHIEUNHAP_delete(?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaCTPN);
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
            _connect.closeConnection();            
        }
        return resultSet;
    }
     public int deletePN(String MaPN){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_PHIEUNHAP_delete(?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaPN);
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
            _connect.closeConnection();            
        }
        return resultSet;
    }
    public ArrayList<CTPHIEUNHAP> searchCTPN(String MaCTPN,String MaSach,String dongiatu,String dongiaden,String tongtientu,String tongtienden){
        ArrayList<CTPHIEUNHAP> ctphieunhaps = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "select * from CHITIETPHIEUNHAP where 1=1";
            if(MaCTPN!=null&&!MaCTPN.isEmpty()){
                Query+=" and MaCTPN like ?";
            }
            if(MaSach!=null&&!MaSach.isEmpty()){
                Query+=" and MaSach like ?";
            }
            if(dongiatu!=null&&!dongiatu.isEmpty()){
                Query+=" and DonGia >= ?";
            }

            if(dongiaden!=null&&!dongiaden.isEmpty()){
                Query+=" and DonGia <= ?";
            }
            if(tongtientu!=null&&!tongtientu.isEmpty()){
                Query+=" and ThanhTien <= ?";
            }
            if(tongtienden!=null&&!tongtienden.isEmpty()){
                Query+=" and ThanhTien >=?";
            }
            preparedStatement = connection.prepareStatement(Query);
            int index = 1;
            if(MaCTPN!=null&&!MaCTPN.isEmpty()){
                preparedStatement.setString(index++,"%"+ MaCTPN+"%");
            }
            if(MaSach!=null&&!MaSach.isEmpty()){
                preparedStatement.setString(index++,"%"+ MaSach+"%");
            }            
            if(dongiatu!=null&&!dongiatu.isEmpty()){
                Double dongia = Double.parseDouble(dongiatu);
                preparedStatement.setDouble(index++,dongia);
            }
            if(dongiaden!=null&&!dongiaden.isEmpty()){
                Double dongia = Double.parseDouble(dongiaden);
                preparedStatement.setDouble(index++,dongia);
            }
            if(tongtientu!=null&&!tongtientu.isEmpty()){
                Double tongtien = Double.parseDouble(tongtientu);
                preparedStatement.setDouble(index++, tongtien);
            }
            if(tongtienden!=null&&!tongtienden.isEmpty()){
                Double tongtien = Double.parseDouble(tongtienden);
                preparedStatement.setDouble(index++, tongtien);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(Query);
            while(resultSet.next()){
                CTPHIEUNHAP ctphieunhap = new CTPHIEUNHAP();
                ctphieunhap.setMaCTPN(resultSet.getString("MaCTPN"));
                ctphieunhap.setMaPN(resultSet.getString("MaPN"));
                ctphieunhap.setMaSach(resultSet.getString("MaSach"));
                ctphieunhap.setDonGia(resultSet.getDouble("DonGia"));
                ctphieunhap.setSoLuong(resultSet.getInt("Soluong"));
                ctphieunhap.setThanhTien(resultSet.getDouble("Thanhtien"));
                ctphieunhaps.add(ctphieunhap);
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
        return ctphieunhaps;
    }
    public int countCTPN(){
        int count =0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "select count(MaCTPN) from CHITIETPHIEUNHAP ";
            preparedStatement = connection.prepareStatement(Query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt(1);
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
        return count;
    }
}
