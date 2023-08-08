package edu.huflit.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.huflit.myapplication.R;

public class CDNDatCho extends AppCompatActivity {

    ImageView img_cdn_home, img_cdn_tk;

    Button btn_Cdn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdn_dat_cho);
        img_cdn_home= findViewById(R.id.img_cdn_home);
        img_cdn_tk = findViewById(R.id.img_cdn_tk);
        btn_Cdn = findViewById(R.id.btn_cdn_datcho);


        img_cdn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
                startActivity(i);
            }
        });

        img_cdn_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ChuaDangNhap_TK.class);
                startActivity(i);
            }
        });

        btn_Cdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhLogin.class);
                startActivity(i);
            }
        });

    }
}