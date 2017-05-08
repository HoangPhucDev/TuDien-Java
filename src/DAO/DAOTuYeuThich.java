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


/**
 *
 * @author Admin
 */
public class DAOTuYeuThich {
    
     public static List<model.TuYeuThich> getListTuYeuThich() throws SQLException
    {
           Connection connection = null;

           connection = ConnectDBSQL.getConnectionString();

           Statement statement = connection.createStatement();
           String sql = "SELECT f.Id,f.Word,f.Detail,g.Id,g.Name FROM dbo.FAV f,dbo.GroupFAV g WHERE f.Id_GroupFAV = g.Id";
           ResultSet rs = statement.executeQuery(sql);
           List<model.TuYeuThich> ListFav = new ArrayList() ;
           while (rs.next()) {
             model.TuYeuThich Fav = new model.TuYeuThich();
             model.DanhSachTuDienYeuThich DS = new model.DanhSachTuDienYeuThich();
             
             Fav.setId(rs.getInt(1));
             Fav.setWord(rs.getString(2));
             Fav.setDetail(rs.getString(3));
             
             DS.setId(rs.getInt(4));
             DS.setName(rs.getString(5));
             
             Fav.setGroupFAV(DS);
             
             ListFav.add(Fav);
           }
           rs.close();
           connection.close();
           statement.close();
           return ListFav;

    }

     public static List<model.TuYeuThich> getByGroup(int idGroup) throws SQLException
    {

           Connection connection = null;

           connection = ConnectDBSQL.getConnectionString();

           String sql = "SELECT f.Id,f.Word,f.Detail,g.Id,g.Name FROM dbo.FAV f,dbo.GroupFAV g WHERE f.Id_GroupFAV = g.Id and f.Id_GroupFAV=?";
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setInt(1, idGroup);
           ResultSet rs = ps.executeQuery();
           List<model.TuYeuThich> ListFav = new ArrayList<>() ;
          while (rs.next()) {
             model.TuYeuThich Fav = new model.TuYeuThich();
             model.DanhSachTuDienYeuThich DS = new model.DanhSachTuDienYeuThich();
             
             Fav.setId(rs.getInt(1));
             Fav.setWord(rs.getString(2));
             Fav.setDetail(rs.getString(3));
             
             DS.setId(rs.getInt(4));
             DS.setName(rs.getString(5));
             
             Fav.setGroupFAV(DS);
             
             ListFav.add(Fav);
           }
           rs.close();
           connection.close();
           ps.close();
           return ListFav;

    }
     
    /**
     *
     * @param Id
     * @param Word
     * @param Detail
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int Update(int Id,String Word,String Detail) throws SQLException{
         int CheckRS=0;
            Connection connection = ConnectDBSQL.getConnectionString();
            String sql = "UPDATE dbo.FAV SET Word=?,Detail=? WHERE Id=?";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1, Word);
            ps.setString(2, Detail);
            ps.setInt(3, Id);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            CheckRS=rs;

           return CheckRS;
    }
    
    /**
     * @param id
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int Delete(int id) throws SQLException{
         int CheckRS=0;

            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps;
            String sql = "Delete from dbo.FAV WHERE Id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            CheckRS=rs;

        return  CheckRS;
    }
    
    /**
     * @param IdGroup
     * @param Word
     * @param Detail
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int Insert(int IdGroup,String Word,String Detail) throws SQLException{
       int CheckRS=0;

            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps;
            String sql = "INSERT INTO dbo.FAV( Id_GroupFAV, Word, Detail ) VALUES  ( ?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, IdGroup);
            ps.setString(2, Word);
            ps.setNString(3, Detail);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            CheckRS=(rs);

        return CheckRS;
    }
    
    public static int getMaxId() throws SQLException
    {

           Connection connection = null;

           connection = ConnectDBSQL.getConnectionString();

           Statement statement = connection.createStatement();
           String sql = "SELECT max(Id) FROM dbo.FAV";
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
