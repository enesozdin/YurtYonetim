/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yurtyonetim.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

public class conn {
    static Connection cnn; 
    static Statement stm;
    public void Baglan(){
        
     try {
             cnn = DriverManager.getConnection("jdbc:postgresql://localhost/yurtyonetim_db", "postgres", "abc123");
         System.out.println("Bağlantı Başarılı");
         } catch (SQLException e) {
             System.out.println(e);
         }
     
}
    public void Ekle(String sorgu){
        try {
        	cnn.setAutoCommit(false);
            stm=cnn.createStatement();
            stm.executeUpdate(sorgu);
            cnn.commit();
        } catch (SQLException ex) {
            System.out.println("hata="+ex);
        }
    
    }
    public void Sil(String sorgu){
        try {
            stm=cnn.createStatement();
            stm.executeUpdate(sorgu);
        } catch (SQLException ex) {
            System.out.println("hata="+ex);
        }
    }
    public void Guncelle(String sorgu){
        try {
            stm=cnn.createStatement();
            stm.executeUpdate(sorgu);
        } catch (SQLException ex) {
            System.out.println("hata="+ex);
        }
    
   }
    public ResultSet Getir(String sorgu){
            ResultSet rs=null;
        try {
            stm=cnn.createStatement();
            rs=stm.executeQuery(sorgu);
        } catch (SQLException ex) {
            System.out.println("Ekleme Başarısız");
        }
        return rs;
    }

    public ResultSet girisyetkisi(String sorgu2){
            ResultSet rs1=null;
        try {
            stm=cnn.createStatement();
            rs1=stm.executeQuery(sorgu2);
        } catch (SQLException ex) {
            System.out.println("Ekleme Başarısız");
        }
        return rs1;
    }
   
    
}
