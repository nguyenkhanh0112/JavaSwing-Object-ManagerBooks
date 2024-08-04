package _Connection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Nguyen Khanh
 */
public class ConnectDB_SQLServer {
    private static final String url = "jdbc:sqlserver://DESKTOP-PKDF6GS\\SQLEXPRESS:1433;databaseName=BooksManagement;encrypt=true;trustServerCertificate=true";
    private static final String user ="sa";
    private static final String password ="123456";
    private static Connection _connection = null;

    public  ConnectDB_SQLServer() {
//       try{
//           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//       }catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
        
    }
    public synchronized Connection getConnection() throws SQLException{
         if (_connection == null || _connection.isClosed()) {
            _connection = DriverManager.getConnection(url, user, password);
        }
        return _connection;
    }
    public synchronized void closeConnection(){
        try{
            if(_connection != null && !_connection.isClosed()) 
                _connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
//    public static void main(String[] args){
//            try {
//                Connection con = getConnection();
//                System.out.println("Ket noi thanh cong");
//                DatabaseMetaData data = (DatabaseMetaData) con.getMetaData();
//                // hien thi thong tin sql khi ket noi thanh cong
//                System.out.println("Driver Name: " + data.getDriverName());
//                System.out.println("Driver Version: " + data.getDriverVersion());
//                System.out.println("Product Name: " + data.getDatabaseProductName());
//                System.out.println("Version: " + data.getDatabaseProductVersion());
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    
}

