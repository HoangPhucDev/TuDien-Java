/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import helper.ReadPropertiesLibrary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;


public class ConnectDBSQL {

 public static Connection getConnectionString() throws SQLException
 {
    
       
    //Properties properties =  ReadPropertiesLibrary.readFileProperties();   
    //String hostName = "localhost";
    // String sqlInstanceName = "SQLEXPRESS";
    // String database = "Tudien";
    String url = "jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName=Tudien";
    String userName = "sa";
    String password = "root";
     
     
     
     return getConnectionString(url, userName, password);
 }
  private static Connection getConnectionString(String url, String userName,
         String password) throws SQLException {
      
     try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "Lỗi: Không Tìm Thấy Thư viện điều khiển SQLServer \n"+ex, "Thông Báo", 0);
         
     }
     
     Connection conn = DriverManager.getConnection(url, userName,password);
     return conn;
 }
  
 private static Connection getConnectionString(String hostName,
         String sqlInstanceName, String database, String userName,
         String password) throws SQLException {

     try {
         // Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     } catch (ClassNotFoundException ex) {
         JOptionPane.showMessageDialog(null, "Lỗi: Không Tìm Thấy Thư viện điều khiển SQLServer \n"+ex, "Thông Báo", 0);
     }

     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
 
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
 

 

}
