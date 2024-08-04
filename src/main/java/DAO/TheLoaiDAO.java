/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.THELOAI;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khanh
 */
public class TheLoaiDAO {
    private _Connection.ConnectDB_SQLServer _Connect=null;
    private CallableStatement callableStatement=null;

    public TheLoaiDAO() {
        _Connect = new _Connection.ConnectDB_SQLServer();
    }
    
    public ArrayList<THELOAI> selectAllTL(){
        ArrayList<THELOAI> categorys = new ArrayList<>();
        try {
            Connection connection = _Connect.getConnection();
            String Query = "{Call proc_THELOAI_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                THELOAI category = new THELOAI();
                category.setMaTL(resultSet.getString("MaTL"));
                category.setTenTL(resultSet.getString("TenTL"));
                category.setMoTa(resultSet.getString("MoTa"));
                categorys.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(callableStatement!=null){
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return categorys;
    }
    
}
