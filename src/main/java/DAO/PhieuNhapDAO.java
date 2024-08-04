/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CTPHIEUNHAP;
import Model.PHIEUNHAP;
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
public class PhieuNhapDAO {
    private _Connection.ConnectDB_SQLServer _connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement preparedStatement = null;


    public PhieuNhapDAO() {
        _connect = new ConnectDB_SQLServer();
    }
    public ArrayList<PHIEUNHAP> selectAll(){
        ArrayList<PHIEUNHAP> arrayList = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_PHIEUNHAP_select_all }";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                PHIEUNHAP phieunhap = new PHIEUNHAP();
                phieunhap.setMaPN(resultSet.getString("MaPN"));
                phieunhap.setMaNV(resultSet.getString("MaNV"));
                phieunhap.setMaNCC(resultSet.getString("MaNCC"));
                phieunhap.setTrangThai(resultSet.getInt("TrangThai"));
                phieunhap.setTongTien(resultSet.getDouble("TongTien"));
                phieunhap.setNgayNhap(resultSet.getDate("NgayNhap"));
                arrayList.add(phieunhap);
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
    public int insertPN(String MaPN, String MaNV, String MaNCC, int TrangThai, double TongTien, Date NgayNhap){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_PHIEUNHAP_insert(?,?,?,?,?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaPN);
            callableStatement.setString(2, MaNV);
            callableStatement.setString(3, MaNCC);
            callableStatement.setInt(4, TrangThai);
            callableStatement.setDouble(5, TongTien);
            callableStatement.setDate(6, NgayNhap);
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
    public int updatePN(String MaPN, String MaNV, String MaNCC, int TrangThai, double TongTien, Date NgayNhap){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_PHIEUNHAP_update(?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaPN);
            callableStatement.setString(2, MaNV);
            callableStatement.setString(3, MaNCC);
            callableStatement.setInt(4, TrangThai);
            callableStatement.setDouble(5, TongTien);
            callableStatement.setDate(6, NgayNhap);
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
    public ArrayList<PHIEUNHAP> searchPN(String MaPN,String MaNV,String MaNCC,String khoangtientu,String khoangtienden,java.util.Date time1,java.util.Date time2){
        ArrayList<PHIEUNHAP> phieunhaps = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "select * from PHIEUNHAP where 1=1";
            if(MaPN!=null&&!MaPN.isEmpty()){
                Query+=" and MaPN like ?";
            }
            if(MaNV!=null&&!MaNV.isEmpty()){
                Query+=" and MaNV like ?";
            }
            if(MaNCC!=null&&!MaNCC.isEmpty()){
                Query+=" and MaNCC like ?";
            }
            if(khoangtientu!=null&&!khoangtientu.isEmpty()){
                Query+=" and TongTien >= ?";
            }
            if(khoangtienden!=null&&!khoangtienden.isEmpty()){
                Query+=" and TongTien <= ?";
            }
            if(time1!=null){
                Query+=" and NgayNhap >=?";
            }
            if(time2!=null){
                Query+=" and NgayNhap <=?";
            }
            preparedStatement = connection.prepareStatement(Query);
            int index = 1;
            if(MaPN!=null&&!MaPN.isEmpty()){
                preparedStatement.setString(index++,"%"+MaPN+"%");
            }
            if(MaNV!=null&&!MaNV.isEmpty()){
                preparedStatement.setString(index++,"%"+MaNV+"%");
            }            
            if(MaNCC!=null&&!MaNCC.isEmpty()){
                preparedStatement.setString(index++,"%"+MaNCC+"%");
            }
            if(khoangtientu!=null&&!khoangtientu.isEmpty()){
                Double tongtien = Double.parseDouble(khoangtientu);
                preparedStatement.setDouble(index++, tongtien);
            }
            if(khoangtienden!=null&&!khoangtienden.isEmpty()){
                Double tongtien = Double.parseDouble(khoangtienden);
                preparedStatement.setDouble(index++, tongtien);
            }
            if(time1!=null){
               java.sql.Date sqlNgayBD = new java.sql.Date(time1.getTime());
               preparedStatement.setDate(index++, sqlNgayBD);
            }
            if(time2!=null){
               java.sql.Date sqlNgayKT = new java.sql.Date(time2.getTime());
               preparedStatement.setDate(index++, sqlNgayKT);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                PHIEUNHAP phieunhap = new PHIEUNHAP();
                phieunhap.setMaPN(resultSet.getString("MaPN"));
                phieunhap.setMaNV(resultSet.getString("MaNV"));
                phieunhap.setMaNCC(resultSet.getString("MaNCC"));
                phieunhap.setTrangThai(resultSet.getInt("TrangThai"));
                phieunhap.setTongTien(resultSet.getDouble("TongTien"));
                phieunhap.setNgayNhap(resultSet.getDate("NgayNhap"));
                phieunhaps.add(phieunhap);
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
        return phieunhaps;
    }
 public int updatePN(String MaPN, double TongTien){
        int resultSet =0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "update PHIEUNHAP set Tongtien = ? where MaPN = ?";
            preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setDouble(1, TongTien);
            preparedStatement.setString(2, MaPN);
            resultSet = preparedStatement.executeUpdate();
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
        return resultSet;
    }
 public ArrayList<CTPHIEUNHAP> select_by_MaPN(String MaPN){
        ArrayList<CTPHIEUNHAP> ctPhieunhaps = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_PHIEUNHAP_search_by_MaPN(?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaPN);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                CTPHIEUNHAP ctphieunhap = new CTPHIEUNHAP();
                ctphieunhap.setMaCTPN(resultSet.getString("MaCTPN"));
                ctphieunhap.setMaPN(resultSet.getString("MaPN"));
                ctphieunhap.setMaSach(resultSet.getString("MaSach"));
                ctphieunhap.setDonGia(resultSet.getDouble("DonGia"));
                ctphieunhap.setSoLuong(resultSet.getInt("Soluong"));
                ctphieunhap.setThanhTien(resultSet.getDouble("ThanhTien"));
                ctPhieunhaps.add(ctphieunhap);
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
        return ctPhieunhaps;
    }
}
