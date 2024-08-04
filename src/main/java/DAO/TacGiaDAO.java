/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NHAXUATBAN;
import Model.TACGIA;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khanh
 */
public class TacGiaDAO {
      private _Connection.ConnectDB_SQLServer _Connect=null;
    private CallableStatement callableStatement=null;

    public TacGiaDAO(){
        _Connect = new _Connection.ConnectDB_SQLServer();
    }
    public ArrayList<TACGIA> selectAllTG(){
        ArrayList<TACGIA> authors = new ArrayList<>();
        try{
            Connection connection = _Connect.getConnection();
            String Query = "{Call proc_TACGIA_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
            TACGIA author = new TACGIA();
            author.setMaTG(resultSet.getString("MaTG"));
            author.setTenTacGia(resultSet.getString("TenTacGia"));
            author.setNgaySinh(resultSet.getDate("NgaySinh"));
            author.setQuocTich(resultSet.getString("QuocTich"));
            author.setTieuSu(resultSet.getString("TieuSu"));
            authors.add(author);
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
        
        return authors;
    }
    
}
