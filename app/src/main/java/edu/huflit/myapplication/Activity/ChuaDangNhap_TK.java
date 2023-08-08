package edu.huflit.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.huflit.myapplication.R;

public class ChuaDangNhap_TK extends AppCompatActivity {
    Button btndn;
    ImageView imgHome,img_datcho_tk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chua_dang_nhap_tk);


        btndn = findViewById(R.id.btn_cdn_tk);
        imgHome = findViewById(R.id.img_home_tk);
        img_datcho_tk = findViewById(R.id.img_datcho_tk);

        btndn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhLogin.class);
                startActivity(i);
            }
        });

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
                startActivity(i);
            }
        });
        img_datcho_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CDNDatCho.class);
                startActivity(i);
            }
        });
    }
}