package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
 import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import edu.huflit.myapplication.R;

public class ManHinhTimKiemTour extends AppCompatActivity {

    ImageView tour1_next_chi_tiet,imgback;

    TextView gia_ban_dau1, gia_ban_dau2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_tim_kiem_tour);
        anhXa();
        gia_ban_dau1.setPaintFlags(gia_ban_dau1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        gia_ban_dau2.setPaintFlags(gia_ban_dau2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        //CLICK VÀO TOUR ĐỂ ĐẾN CHI TIẾT TOUR
        tour1_next_chi_tiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_ct_tour1 = new Intent(getApplicationContext(), ManHinhChiTietTour.class);
                startActivity(next_ct_tour1);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_ct_tour1 = new Intent(getApplicationContext(), TrangChu.class);
                startActivity(next_ct_tour1);
            }
        });
    }
    public void anhXa()
    {
        gia_ban_dau1 = (TextView) findViewById(R.id.gia_bd_tkt_1);
        gia_ban_dau2 = (TextView) findViewById(R.id.gia_bd_tkt_2);
        tour1_next_chi_tiet = (ImageView) findViewById(R.id.tour1_next_chitiet);
        imgback = findViewById(R.id.img_back_tkt);
    }
}