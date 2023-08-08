package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.bumptech.glide.Glide;

import edu.huflit.myapplication.R;

public class ManHinhChiTietTour extends AppCompatActivity {

    Button next_dat_tour;

    TextView hdv,ptdc,gia,tenTour;
    ReadMoreTextView rmMota;
    ImageView AnhNen,backHome;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chi_tiet_tour);
        anhXa();
        Views();


    }
    public void anhXa()
    {

        next_dat_tour = findViewById(R.id.next_dat_tour);
        rmMota = findViewById(R.id.tvLichTrinh_Details);
        hdv =findViewById(R.id.tv_hdv_details);
        ptdc = findViewById(R.id.tv_ptdc_details);
        tenTour = findViewById(R.id.tvTen_Details);
        gia = findViewById(R.id.tvGia_Details);
        AnhNen = findViewById(R.id.imgAnh_Details);
        backHome = findViewById(R.id.imgBackHome_DT);
    }

    public void Views(){

        String tentour= getIntent().getExtras().getString("TenTour");
        String mota = getIntent().getExtras().getString("MoTa");
        String Anh = getIntent().getExtras().getString("Anh");
        String HDV = getIntent().getExtras().getString("HDV");
        String PTDC = getIntent().getExtras().getString("PTDC");
        int giatien = getIntent().getExtras().getInt("Tien");

        tenTour.setText(tentour);
        rmMota.setText(mota);
        hdv.setText(HDV);
        ptdc.setText(PTDC);
        gia.setText(String.valueOf(giatien));
        Glide.with(this).load(Anh).into(AnhNen);

        next_dat_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_dt = new Intent(getApplicationContext(), ManHinhDatTour.class);
                startActivity(next_dt);
            }
        });

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), TrangChu.class);
                startActivity(home);
            }
        });
    }
}