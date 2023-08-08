package edu.huflit.myapplication.Models;

public class User {

    private String TaiKhoan;
    private String Matkhau;

    public User() {
    }

    public User(String taiKhoan, String matkhau) {
        TaiKhoan = taiKhoan;
        Matkhau = matkhau;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String matkhau) {
        Matkhau = matkhau;
    }
}
