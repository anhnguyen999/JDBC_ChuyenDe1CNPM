/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import Entities.SanPham;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class SanPhamsDAL {
 
    private Connection connectiondb;

    public SanPhamsDAL() throws FileNotFoundException, IOException, SQLException {
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        
        String user = props.getProperty("user");
        String password = props.getProperty("pass");
        String con = props.getProperty("con");
        
        connectiondb = DriverManager.getConnection(con,user,password);
    }
    
    public boolean addSanPham(SanPham newSanPham){
        //code them san pham
        return true; //neu them thanh cong
//        return false; //neu them that bai
    }
    
    //Tim kiem san pham
    public List<SanPham> searchSanPham(){
         List<SanPham> list = new ArrayList<SanPham>();
         //code tim kiem san pham
         //vao db thuc hien truy van
         return list;
    }
    
    
    //load all san pham
    public List<SanPham> getSanPhams() throws SQLException{
        
        List<SanPham> list = new ArrayList<SanPham>();
        
        Statement states = null;
        ResultSet res = null;
        
        try {
            String sql = "select * from SanPhams";
            states = connectiondb.createStatement();
            res = states.executeQuery(sql);
            
            while (res.next()) {
              int ma = res.getInt("Ma");
              String ten = res.getString("Ten");
              float gia = res.getFloat("gia");
              int maLoai = res.getInt("maLoai");
              
              SanPham sanPham = new SanPham(ma, ten, gia, maLoai);
              
              list.add(sanPham);
            }
            return list;
        }
        finally{
            if(states!=null)
                states.close();
            if(res!=null)
                res.close();
        }        
    }

    public List<SanPham> getSanPhamsByLoai(int maLoaiSanPham) throws SQLException {
         List<SanPham> list = new ArrayList<SanPham>();
        
        Statement states = null;
        ResultSet res = null;
        
        try {
            String sql = "select * from SanPhams where maloai="+maLoaiSanPham;
            states = connectiondb.createStatement();
            res = states.executeQuery(sql);
            
            while (res.next()) {
              int ma = res.getInt("Ma");
              String ten = res.getString("Ten");
              float gia = res.getFloat("gia");
              int maLoai = res.getInt("maLoai");
              
              SanPham sanPham = new SanPham(ma, ten, gia, maLoai);
              
              list.add(sanPham);
            }
            return list;
        }
        finally{
            if(states!=null)
                states.close();
            if(res!=null)
                res.close();
        }        
    }
    
}
