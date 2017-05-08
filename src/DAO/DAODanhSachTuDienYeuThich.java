/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DanhSachTuDienYeuThich;


/**
 *
 * @author Admin
 */
public class DAODanhSachTuDienYeuThich {
    public static List<DanhSachTuDienYeuThich> getListTudien() throws SQLException
    {

           Connection connection = null;
           connection = ConnectDBSQL.getConnectionString();
           Statement statement = connection.createStatement();
           String sql = "SELECT Id,Name FROM dbo.GroupFAV";
           ResultSet rs = statement.executeQuery(sql);
           List<DanhSachTuDienYeuThich> ListFav = new ArrayList<>() ;
           while (rs.next()) {
             DanhSachTuDienYeuThich Fav = new DanhSachTuDienYeuThich();
             Fav.setId(rs.getInt(1));
             Fav.setName(rs.getString(2));
             ListFav.add(Fav);
           }
           rs.close();
           connection.close();
           statement.close();
           return ListFav;
     
      
    }

    /**
     *
     * @param Id
     * @param name
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int Update(int Id,String name) throws SQLException{
       int Checkrs=0;

            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps = null;
            String sql = "UPDATE dbo.GroupFAV SET Name=? WHERE Id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, Id);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            Checkrs=rs;

        return Checkrs;
    }
    
    /**
     * @param id
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int Delete(int id) throws SQLException{
        int Checkrs=0;
            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps;
            String sql = "Delete from dbo.GroupFAV WHERE Id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            Checkrs= rs;

       return Checkrs;
    }
    
    /**
     * @param name
     * @return 
     * @throws java.sql.SQLException 
     */
    public static int Insert(String name) throws SQLException{
        int Checkrs = 0;

            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps;
            String sql = "INSERT INTO dbo.GroupFAV(Name) VALUES(?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            Checkrs=rs;

        return Checkrs;
    }
    
    public static int getMaxId() throws SQLException
    {

           Connection connection = null;
           connection = ConnectDBSQL.getConnectionString();
           Statement statement = connection.createStatement();
           String sql = "SELECT max(Id) FROM dbo.GroupFAV";
           ResultSet rs = statement.executeQuery(sql);
           int maxid=0;
           while (rs.next()) {
             maxid  = rs.getInt(1);
           }
           rs.close();
           connection.close();
           statement.close();
           return maxid;

    }
    
   
}
