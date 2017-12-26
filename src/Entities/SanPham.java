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
public class SanPham {

    public SanPham(int ma, String ten, float gia, int maLoai) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.maLoai = maLoai;
    }
    
    public int ma;
    
    public String ten;
    
    public float gia;
    
    public int maLoai;

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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }
    
    
}
