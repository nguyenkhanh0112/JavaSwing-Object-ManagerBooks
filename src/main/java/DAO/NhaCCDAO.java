/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NCC;
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
public class NhaCCDAO {
    private _Connection.ConnectDB_SQLServer _connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement preparedStatement = null;

    public NhaCCDAO() {
        _connect = new ConnectDB_SQLServer();
    }
    public ArrayList<NCC> selectAll(){
        ArrayList<NCC> nccs = new ArrayList<>();
        try{
            Connection connection = _connect.getConnection();
            String Query = "{call proc_NCC_select_all }";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                NCC ncc = new NCC();
                ncc.setMaNCC(resultSet.getString("MaNCC"));
                ncc.setTenNCC(resultSet.getString("TenNCC"));
                ncc.setDiaChi(resultSet.getString("DiaChi"));
                ncc.setSDT(resultSet.getString("SDT"));
                ncc.setEmail(resultSet.getString("Email"));
                ncc.setNguoiLienHe(resultSet.getString("NguoiLienHe"));
                nccs.add(ncc);
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
        return nccs;
    }
    public int insertNCC(String MaNCC, String TenNCC, String DiaChi, String SDT, String Email, String NguoiLienHe){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_NCC_insert(?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaNCC);
            callableStatement.setString(2, TenNCC);
            callableStatement.setString(3, DiaChi);
            callableStatement.setString(4, SDT);
            callableStatement.setString(5, Email);
            callableStatement.setString(6, NguoiLienHe);  
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
        public int updateNCC(String MaNCC, String TenNCC, String DiaChi, String SDT, String Email, String NguoiLienHe){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_NCC_update(?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaNCC);
            callableStatement.setString(2, TenNCC);
            callableStatement.setString(3, DiaChi);
            callableStatement.setString(4, SDT);
            callableStatement.setString(5, Email);
            callableStatement.setString(6, NguoiLienHe);  
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
    public int deleteNCC(String MaNCC){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_NCC_delete(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaNCC);
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
}
