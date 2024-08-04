/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CTGIAMGIA;
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
public class CTGiamGiaDAO {
    private _Connection.ConnectDB_SQLServer _connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement preparedStatement = null;

    public CTGiamGiaDAO() {
        _connect = new ConnectDB_SQLServer();
    }
    public ArrayList<CTGIAMGIA> selectAll(){
        ArrayList<CTGIAMGIA> arrayList = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITIETGIAMGIA_select_all }";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                CTGIAMGIA giamgia = new CTGIAMGIA();
                giamgia.setMaGG(resultSet.getString("MaGG"));
                giamgia.setMaSach(resultSet.getString("MaSach"));
                giamgia.setPhanTramGG(resultSet.getDouble("PhanTramGG"));
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
        public ArrayList<CTGIAMGIA> select_by_MaGG(String MaGG){
        ArrayList<CTGIAMGIA> arrayList = new ArrayList<>();
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITIETGIAMGIA_select_by_MaGG(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaGG);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                CTGIAMGIA giamgia = new CTGIAMGIA();
                giamgia.setMaGG(resultSet.getString("MaGG"));
                giamgia.setMaSach(resultSet.getString("MaSach"));
                giamgia.setPhanTramGG(resultSet.getDouble("PhanTramGG"));
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
    public int insertCTGG(String MaGG, String MaSach, double PhanTramGG){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITIETGIAMGIA_insert(?,?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaGG);
            callableStatement.setString(2, MaSach);
            callableStatement.setDouble(3, PhanTramGG);
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
    public int updateCTGG(String MaGG, String MaSach, double PhanTramGG){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITITETGIAMGIA_update (?,?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaGG);
            callableStatement.setString(2, MaSach);
            callableStatement.setDouble(3, PhanTramGG);
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
     public int deleteCTGG(String MaGG,String MaSach){
        int resultSet = 0;
        try {
            Connection connection = _connect.getConnection();
            String Query = "{call proc_CHITIETGIAMGIA_delete(?,?) }";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaGG);
            callableStatement.setString(2, MaSach);
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
    public CTGIAMGIA getPhanTramGG(String MaGG,String MaSach){
        CTGIAMGIA ctgg = new CTGIAMGIA();
        try{
            Connection connection = _connect.getConnection();
            String Query = "select * from CTGIAMGIA where 1=1";
            if(MaGG!=null&&!MaGG.isEmpty()){
                Query+="and MaGG = ?";
            } 
            if(MaSach!=null&&!MaSach.isEmpty()){
                Query+="and MaSach = ?";
            }
            preparedStatement = connection.prepareStatement(Query);
            int index =1;
            if(MaGG!=null&&!MaGG.isEmpty()){
                preparedStatement.setString(index++, MaGG);
            }
            if(MaSach!=null&&!MaSach.isEmpty()){
                preparedStatement.setString(index++, MaSach);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ctgg.setMaGG(resultSet.getString("MaGG"));
                ctgg.setMaSach(resultSet.getString("MaSach"));
                ctgg.setPhanTramGG(resultSet.getDouble("PhamTramGG"));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
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
        return ctgg;
    }
}
