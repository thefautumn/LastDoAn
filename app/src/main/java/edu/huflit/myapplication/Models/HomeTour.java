package edu.huflit.myapplication.Models;

import java.util.Date;

import edu.huflit.myapplication.Adapter.HomeRecAdapter;

public class HomeTour {
    private String Ten_tour;
    private String Anhbia;
    private int SoTien;

    public HomeTour() {
    }
    public HomeTour(String ten_tour, String anhbia, int soTien) {
        Ten_tour = ten_tour;
        Anhbia = anhbia;
        SoTien = soTien;
    }
    private String mota;


    public HomeTour(String ten_tour, String anhbia, int soTien, String mota, int id, String HDV, String PTDC) {
        Ten_tour = ten_tour;
        Anhbia = anhbia;
        SoTien = soTien;
        this.mota = mota;
        this.id = id;
        this.HDV = HDV;
        this.PTDC = PTDC;
    }

    private Date Ngay_khoi_hanh;
    private Date Ngay_Ket_thuc;

    public String getTen_tour() {
        return Ten_tour;
    }

    public void setTen_tour(String ten_tour) {
        Ten_tour = ten_tour;
    }

    public String getAnhbia() {
        return Anhbia;
    }

    public void setAnhbia(String anhbia) {
        Anhbia = anhbia;
    }

    public int getSoTien() {
        return SoTien;
    }

    public void setSoTien(int soTien) {
        SoTien = soTien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Date getNgay_khoi_hanh() {
        return Ngay_khoi_hanh;
    }

    public void setNgay_khoi_hanh(Date ngay_khoi_hanh) {
        Ngay_khoi_hanh = ngay_khoi_hanh;
    }

    public Date getNgay_Ket_thuc() {
        return Ngay_Ket_thuc;
    }

    public void setNgay_Ket_thuc(Date ngay_Ket_thuc) {
        Ngay_Ket_thuc = ngay_Ket_thuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getHDV() {
        return HDV;
    }

    public void setHDV(String HDV) {
        this.HDV = HDV;
    }

    public String getPTDC() {
        return PTDC;
    }

    public void setPTDC(String PTDC) {
        this.PTDC = PTDC;
    }

    private String HDV;
    private String PTDC;

}
