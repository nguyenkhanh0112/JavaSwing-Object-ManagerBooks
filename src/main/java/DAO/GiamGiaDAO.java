/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.GIAMGIA;
import _Connection.ConnectDB_SQLServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khanh
 */
public class GiamGiaDAO {
    private _Connection.ConnectDB_SQLServer _connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement preparedStatement = null;
    private String Query = null;

    public GiamGiaDAO() {
        _connect = new _Connection.ConnectDB_SQLServer();
    }
    public ArrayList<GIAMGIA> selectAll(){
        ArrayList<GIAMGIA> arrayList = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            Query = "{call proc_GIAMGIA_select_all }";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                GIAMGIA giamgia = new GIAMGIA();
                giamgia.setMaGG(resultSet.getString("MaGG"));
                giamgia.setTenCT(resultSet.getString("TenCT"));
                giamgia.setLoaiCT(resultSet.getString("LoaiCT"));
                giamgia.setNgayBD(resultSet.getDate("NgaBD"));
                giamgia.setNgayKT(resultSet.getDate("NgayKT"));
                arrayList.add(giamgia);
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
    public int insertGG(String MaGG, String TenCT, String LoaiCT, Date NgayBD, Date NgayKT){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            Query = "{call proc_GIAMGIA_insert(?,?,?,?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaGG);
            callableStatement.setString(2, TenCT);
            callableStatement.setString(3, LoaiCT);
            callableStatement.setDate(4,NgayBD);
            callableStatement.setDate(5, NgayKT);

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
    public int updateGG(String MaGG, String TenCT, String LoaiCT, Date NgayBD, Date NgayKT){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            Query = "{call proc_GIAMGIA_update (?,?,?,?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaGG);
            callableStatement.setString(2, TenCT);
            callableStatement.setString(3, LoaiCT);
            callableStatement.setDate(4,NgayBD);
            callableStatement.setDate(5, NgayKT);
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
     public int deleteGG(String MaGG){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            Query = "{call proc_GIAMGIA_delete(?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaGG);
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
     public ArrayList<GIAMGIA> getListDiscount(java.util.Date NgayBD,java.util.Date NgayKT){
        ArrayList<GIAMGIA> discounts= new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            Query = "select * from GIAMGIA where 1=1";
            if(NgayBD!=null){
                Query +="and NgaBD >= ? ";
            }
            if(NgayKT!=null){
                Query += "and NgayKT <= ? ";
            }
            preparedStatement = connection.prepareStatement(Query);
            int index = 1;
            if(NgayBD!=null){
                java.sql.Date sqlNgayBD = new java.sql.Date(NgayBD.getTime());
                preparedStatement.setDate(index++, sqlNgayBD);
            }
            if(NgayKT!=null){
                java.sql.Date sqlNgayKT = new java.sql.Date(NgayKT.getTime());
                preparedStatement.setDate(index++, sqlNgayKT);
                
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                GIAMGIA discount = new GIAMGIA();
                discount.setMaGG(resultSet.getString("MaGG"));
                discount.setTenCT(resultSet.getString("TenCT"));
                discount.setLoaiCT(resultSet.getString("LoaiCT"));
                discount.setNgayBD(resultSet.getDate("NgaBD"));
                discount.setNgayKT(resultSet.getDate("NgayKT"));
                discounts.add(discount);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(preparedStatement!=null){
                try{
                    preparedStatement.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                _connect.closeConnection();
            }
        }
        return discounts;
    }
}
