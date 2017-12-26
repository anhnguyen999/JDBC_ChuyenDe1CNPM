/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.SanPham;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import Entities.LoaiSanPham;

/**
 *
 * @author Administrator
 */
public class LoaiSanPhamDAL {
    private Connection connectiondb;

    public LoaiSanPhamDAL() throws FileNotFoundException, IOException, SQLException {
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        
        String user = props.getProperty("user");
        String password = props.getProperty("pass");
        String con = props.getProperty("con");
        
        connectiondb = DriverManager.getConnection(con,user,password);
    }
    
    //get All LoaiSanPham
    
     public List<LoaiSanPham> getLoaiSanPhams() throws SQLException{
        
        List<LoaiSanPham> list = new ArrayList<LoaiSanPham>();
        
        Statement states = null;
        ResultSet res = null;
        
        try {
            String sql = "select * from LoaiSanPhams";
            states = connectiondb.createStatement();
            res = states.executeQuery(sql);
            
            while (res.next()) {
              int ma = res.getInt("Ma");
              String ten = res.getString("Ten");
              
              LoaiSanPham loaiSanPham = new LoaiSanPham(ma, ten);
              
              list.add(loaiSanPham);
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
