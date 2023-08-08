package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class ManHinhPhuongThucThanhToan extends AppCompatActivity {

    ImageView back;
    Button btnVcb, btnMomo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_phuong_thuc_thanh_toan);

        back= findViewById(R.id.img_back_pttt);
        btnVcb = findViewById(R.id.btn_pttt_vietcombank);
        btnMomo = findViewById(R.id.btn_pttt_momo);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhThanhToan.class);
                startActivity(i);
            }
        });
        btnVcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhThanhToan.class);
                startActivity(i);
            }
        });
        btnMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhThanhToan.class);
                startActivity(i);
            }
        });


    }
}