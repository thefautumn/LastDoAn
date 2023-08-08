package edu.huflit.myapplication.Activity;

import android.app.appsearch.GetByDocumentIdRequest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class ThongTinDatXe extends AppCompatActivity {

    Button btnthanhtoan;
    ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dat_xe);
        btnthanhtoan = findViewById(R.id.btn_thanhtoan_DX);
        imgback = findViewById(R.id.tv_back_TTDX);

        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhThanhToan.class);
                startActivity(i);
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChonDiemDonXe.class);
                startActivity(i);
            }
        });
    }
}