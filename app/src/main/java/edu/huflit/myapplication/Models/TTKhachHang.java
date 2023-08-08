package edu.huflit.myapplication.Models;

public class TTKhachHang {
        private String diachi;
        private String email;
        private int sdt;
          private int id;
        private String Ten;

    public TTKhachHang(String diachi, String email, int sdt, int id, String ten) {
        this.diachi = diachi;
        this.email = email;
        this.sdt = sdt;
        this.id = id;
        Ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public TTKhachHang() {
    }
}
