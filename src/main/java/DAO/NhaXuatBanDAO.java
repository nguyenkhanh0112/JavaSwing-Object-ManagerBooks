/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NHAXUATBAN;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khanh
 */
public class NhaXuatBanDAO {
    private _Connection.ConnectDB_SQLServer _Connect=null;
    private CallableStatement callableStatement=null;

    public NhaXuatBanDAO() {
        _Connect = new _Connection.ConnectDB_SQLServer();
    }
    public ArrayList<NHAXUATBAN> selectAllNXB(){
        ArrayList<NHAXUATBAN> listNXB = new ArrayList<>();
        try{
             Connection connection = _Connect.getConnection();
            String Query = "{Call proc_NXB_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
            NHAXUATBAN nhaxuatban = new NHAXUATBAN();
            nhaxuatban.setMaNXB(resultSet.getString("MaNXB"));
            nhaxuatban.setTenNXB(resultSet.getString("TenNXB"));
            nhaxuatban.setDiaChi(resultSet.getString("DiaChi"));
            nhaxuatban.setSoDienThoai(resultSet.getString("SoDienThoai"));
            nhaxuatban.setEmail(resultSet.getString("Email"));
            listNXB.add(nhaxuatban);
        }
        }catch(SQLException e){
            e.printStackTrace();
            
        }finally{
            if(callableStatement!=null){
                try {
                    callableStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                _Connect.closeConnection();
            }
        }
        
        return listNXB;
    }
}
