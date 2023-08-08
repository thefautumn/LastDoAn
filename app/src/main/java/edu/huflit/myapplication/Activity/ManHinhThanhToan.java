package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class ManHinhThanhToan extends AppCompatActivity {

    //-----------
    Button next_chon_phuong_thuc_thanh_toan, next_them_voucher;
    //NÚT XÁC NHẬN THANH TOÁN
    Button btn_thanh_toan;
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_thanh_toan);
        anhXa();
        //ẤN NUT CHỌN Ở MÀN HÌNH THANH TOÁN ĐỂ CHON PHƯƠNG THỨC THANH TOÁN
        next_chon_phuong_thuc_thanh_toan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_pttt = new Intent(getApplicationContext(), ManHinhPhuongThucThanhToan.class);
                startActivity(next_pttt);
            }
        });
        next_them_voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_voucher = new Intent(getApplicationContext(), ManHinhThemVoucher.class);
                startActivity(next_voucher);
            }
        });
        //ẤN NÚT THANH TOÁN-->CHUYỂN ĐẾN THANH TOÁN THÀNH CÔNG
        btn_thanh_toan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_thanh_toan_thanh_cong = new Intent(getApplicationContext(), ThanhToanThanhCong.class);
                startActivity(next_thanh_toan_thanh_cong);
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManHinhDatTour.class);
                startActivity(intent);
            }
        });
    }
    public void anhXa()
    {
        next_chon_phuong_thuc_thanh_toan = (Button) findViewById(R.id.next_chon_phuong_thuc_thanh_toan);
        next_them_voucher = (Button) findViewById(R.id.next_them_voucher);
        btn_thanh_toan = (Button) findViewById(R.id.btn_thanh_toan);
        imgBack = findViewById(R.id.img_backTT);

    }
}