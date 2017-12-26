/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Administrator
 */
public class LoaiSanPham {
    
    public int ma;
    
    public String ten;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LoaiSanPham(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
    
    @Override
    public String toString(){
        return ten;
    }
}
