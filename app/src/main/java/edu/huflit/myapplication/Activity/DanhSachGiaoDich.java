package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class DanhSachGiaoDich extends AppCompatActivity {

    Button next_xem_chi_tiet;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_giao_dich);
        anhXa();
        next_xem_chi_tiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ChiTietGiaoDich.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
            }
        });
    }
    public void anhXa()
    {
        next_xem_chi_tiet = (Button) findViewById(R.id.next_xem_chi_tiet);
        back = findViewById(R.id.img_back_dsgd);
    }
}