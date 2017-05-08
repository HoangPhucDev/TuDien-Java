/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import helper.xulychuoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.TuDien;

/**
 *
 * @author Admin
 */
public class DAOTuDien {
        public static List<TuDien> getListTudien() throws SQLException
    {

           Connection connection = null;

           connection = ConnectDBSQL.getConnectionString();
           
           Statement statement = connection.createStatement();
           String sql = "SELECT Id,word,detail FROM dbo.DICT_AV ORDER BY word ASC";
           ResultSet rs = statement.executeQuery(sql);
           List<TuDien> Listword = new ArrayList<>() ;
           while (rs.next()) {
             TuDien Dic = new TuDien();
             Dic.setId(rs.getInt(1));
             Dic.setWord(rs.getString(2));
             Dic.setDetail(xulychuoi.xulyTuDien(rs.getString(3)));
             Listword.add(Dic);
           }
           rs.close();
           connection.close();
           statement.close();
           return Listword;
    }

    /**
     *
     * @param id
     * @param word
     * @param detail
     * @return checkRS
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int Update(int id,String word,String detail) throws SQLException{
        int Checkrs = 0;

            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps = null;
            String sql = "UPDATE dbo.DICT_AV SET word=?,detail=? WHERE Id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, word);
            ps.setNString(2, detail);
            ps.setInt(3, id);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            Checkrs = rs;

        return Checkrs;
    }
    
    /**
     *
     * @param id
     * @return CheckRS

     */
    public static int Delete(int id) throws SQLException{
       int Checkrs = 0;

            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps;
            String sql = "Delete from dbo.DICT_AV WHERE Id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            Checkrs = rs;

        return Checkrs;
    }
    
    /**
     *
     * @param word 
     * @param detail
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static int Insert(String word,String detail) throws SQLException{
        int Checkrs = 0;

            Connection connection = ConnectDBSQL.getConnectionString();
            PreparedStatement ps = null;
            String sql = "INSERT INTO dbo.DICT_AV (word, detail) VALUES(?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, word);
            ps.setNString(2, detail);
            int rs = ps.executeUpdate();
            connection.close();
            ps.close();
            Checkrs = rs ;

        return  Checkrs;
    }
    
    public static int getMaxId() throws SQLException
    {

           Connection connection = null;
           connection = ConnectDBSQL.getConnectionString();
           Statement statement = connection.createStatement();
           String sql = "SELECT max(Id) FROM dbo.DICT_AV";
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
