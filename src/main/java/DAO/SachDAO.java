/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.SACH;
import _Connection.ConnectDB_SQLServer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Khanh
 */
public class SachDAO {
    private ConnectDB_SQLServer _Connect=null;
    private CallableStatement callableStatement=null;
    private PreparedStatement  preparedStatement=null;
    
    public SachDAO(){
        _Connect = new ConnectDB_SQLServer();
    }
    public ArrayList<SACH> selectAllSach(){
        ArrayList<SACH> listBook = new ArrayList<>();
        try{
            Connection connection = _Connect.getConnection();
            String Query ="{call proc_SACH_select_all}";
            callableStatement = connection.prepareCall(Query);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                SACH book = new SACH();
                book.setMaSach(resultSet.getString("MaSach"));
                book.setMaNXB(resultSet.getString("MaNXB"));
                book.setMaTL(resultSet.getString("MaTL"));
                book.setMaTG(resultSet.getString("MaTG"));
                book.setTenSach(resultSet.getString("TenSach"));
                book.setNamXB(resultSet.getInt("NamXB"));
                book.setSoLuong(resultSet.getInt("SoLuong"));
                book.setDonGia(resultSet.getDouble("DonGia"));
                book.setHinhAnh(resultSet.getString("AnhSach"));
                listBook.add(book);
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
            _Connect.closeConnection();
        }
        return listBook;
    }
    
    public ArrayList<SACH> selectByMaSach(String MaSach){
        ArrayList<SACH> listBook = new ArrayList<>();
        try{
            Connection connection = _Connect.getConnection();
            String Query = "{call proc_SACH_select_by_MaSach(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1, MaSach);
            ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                SACH book = new SACH();
                book.setMaSach(resultSet.getString("MaSach"));
                book.setMaNXB(resultSet.getString("MaNXB"));
                book.setMaTL(resultSet.getString("MaTL"));
                book.setMaTG(resultSet.getString("MaTG"));
                book.setTenSach(resultSet.getString("TenSach"));
                book.setNamXB(resultSet.getInt("NamXB"));
                book.setSoLuong(resultSet.getInt("SoLuong"));
                book.setDonGia(resultSet.getDouble("DonGia"));
                book.setHinhAnh(resultSet.getString("AnhSach"));
                listBook.add(book);
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
            _Connect.closeConnection();
        }
        return listBook;
    }
    public int insertSach(String MaSach, String MaNXB, String MaTL, String MaTG, String TenSach, int NamXB, int SoLuong, double DonGia,String hinhanh){
        int resultSet =0;
        try{
            Connection connection = _Connect.getConnection();
            String Query = "{call proc_SACH_insert(?,?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1,MaSach);
            callableStatement.setString(2,MaNXB);
            callableStatement.setString(3,MaTL);
            callableStatement.setString(4,MaTG);
            callableStatement.setString(5,TenSach);
            callableStatement.setInt(6,NamXB);
            callableStatement.setInt(7,SoLuong);
            callableStatement.setDouble(8,DonGia);
            callableStatement.setString(9, hinhanh);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
              if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return resultSet;
    }
    public int updateSach(String MaSach, String MaNXB, String MaTL, String MaTG, String TenSach, int NamXB, int SoLuong, double DonGia,String hinhanh){
        int resultSet =0;
        try{
            Connection connection = _Connect.getConnection();
            String Query = "{call proc_SACH_update(?,?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1,MaSach);
            callableStatement.setString(2,MaNXB);
            callableStatement.setString(3,MaTL);
            callableStatement.setString(4,MaTG);
            callableStatement.setString(5,TenSach);
            callableStatement.setInt(6,NamXB);
            callableStatement.setInt(7,SoLuong);
            callableStatement.setDouble(8,DonGia);
            callableStatement.setString(9,hinhanh);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
              if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return resultSet;
    }
      public int deleteSach(String MaSach){
        int resultSet =0;
        try{
            Connection connection = _Connect.getConnection();
            String Query = "{call proc_SACH_delete(?)}";
            callableStatement = connection.prepareCall(Query);
            callableStatement.setString(1,MaSach);
            resultSet = callableStatement.executeUpdate();
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
              if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
        }
        return resultSet;
    }
      public ArrayList<SACH> searchSach(String MaSach, String MaNXB,String MaTL,String MaTG,String TenSach, String KhoangGiaTu,String KhoangGiaDen,String NamXBTu,String NamXBDen ){
          ArrayList<SACH> listbooks = new ArrayList<>();
          try{
              Connection connection = _Connect.getConnection();
              String Query = "select * from SACH where 1=1";
              if(MaSach!=null && !MaSach.isEmpty()){
                  Query +="and MaSach = ?";
              }
              if(MaNXB != null && !MaNXB.isEmpty()){
                  Query +="and MaNXB = ?";
              }
              if(MaTL != null && !MaTL.isEmpty()){
                  Query += "and MaTL = ?";
              }
              if(MaTG !=null && !MaTG.isEmpty()){
                  Query+= "and MaTG = ?";
              }
              if(TenSach!=null && !TenSach.isEmpty()){
                  Query+= "and TenSach like ?";
              }
              if(KhoangGiaTu!=null && !KhoangGiaTu.isEmpty()){
                  Query+= "and DonGia >= ?";
              }
              if(KhoangGiaDen!=null && !KhoangGiaDen.isEmpty()){
                  Query+="and DonGia<=?";
              }
              if(NamXBTu !=null && !NamXBTu.isEmpty()){
                  Query+="and NamXB >=?";
              }
              if(NamXBTu !=null && !NamXBDen.isEmpty()){
                  Query+="and NamXB<= ?";
              }
              
              preparedStatement = connection.prepareStatement(Query);
              int index =1;
              if(MaSach!=null && !MaSach.isEmpty()){
                  preparedStatement.setString(index++, MaSach);
              }
              if(MaNXB != null && !MaNXB.isEmpty()){
                preparedStatement.setString(index++, MaNXB);
              }
              if(MaTL != null && !MaTL.isEmpty()){
                preparedStatement.setString(index++, MaTL);
              }
              if(MaTG !=null && !MaTG.isEmpty()){
                preparedStatement.setString(index++, MaTG);
              }
              if(TenSach!=null && !TenSach.isEmpty()){
                preparedStatement.setString(index++, TenSach);
              }
              if(KhoangGiaTu!=null && !KhoangGiaTu.isEmpty()){
                Double khoanggia = Double.parseDouble(KhoangGiaTu);
                preparedStatement.setDouble(index++, khoanggia);
              }
              if(KhoangGiaDen!=null && !KhoangGiaDen.isEmpty()){
                Double khoanggia = Double.parseDouble(KhoangGiaDen);
                preparedStatement.setDouble(index++, khoanggia);
              }
              if(NamXBTu !=null && !NamXBTu.isEmpty()){
                int NamXB = Integer.parseInt(NamXBTu);
                preparedStatement.setDouble(index++, NamXB);
              }
              if(NamXBTu !=null && !NamXBDen.isEmpty()){
                int NamXB = Integer.parseInt(NamXBDen);
                preparedStatement.setDouble(index++, NamXB);
              }
              ResultSet resultSet = preparedStatement.executeQuery();
              while(resultSet.next()){
                  SACH book = new SACH();
                  book.setMaSach(resultSet.getString("MaSach"));
                  book.setMaNXB(resultSet.getString("MaNXB"));
                  book.setMaTL(resultSet.getString("MaTL"));
                  book.setMaTG(resultSet.getString("MaTG"));
                  book.setTenSach(resultSet.getString("TenSach"));
                  book.setNamXB(resultSet.getInt("NamXB"));
                  book.setSoLuong(resultSet.getInt("SoLuong"));
                  book.setDonGia(resultSet.getDouble("DonGia"));
                  book.setHinhAnh(resultSet.getString("AnhSach"));
                  listbooks.add(book);
              } 
          }catch(SQLException e){
              e.printStackTrace();
              
          }finally{
                if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            _Connect.closeConnection();
          }
          return listbooks;
      }
      public ArrayList<String> ThongKeSach(){
          ArrayList<String> statisticals = new ArrayList<>();
          try {
              Connection connection = _Connect.getConnection();
              String Query = "{call proc_SACH_ThongKe}";
              callableStatement = connection.prepareCall(Query);
              ResultSet resultSet = callableStatement.executeQuery();
              while(resultSet.next()){
                  String dongiathapnhat = String.valueOf(resultSet.getDouble("DonGiaThapNhat"));
                  String dongiacaonhat = String.valueOf(resultSet.getDouble("DonGiaCaoNhat"));
                  String soloaisach = String.valueOf(resultSet.getInt("soloaisach"));
                  String tongsosach = String.valueOf(resultSet.getInt("TongSoSach"));
                  statisticals.add(dongiathapnhat);
                  statisticals.add(dongiacaonhat);
                  statisticals.add(soloaisach);
                  statisticals.add(tongsosach);
              }
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              if(callableStatement!=null){
                  try {
                      callableStatement.close();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  _Connect.closeConnection();
              }
          }
          return statisticals;
      }
}
