package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import edu.huflit.myapplication.R;

public class ManHinhTaiKhoan extends AppCompatActivity {
    Button btnDangNhap;
    TextView logout;

    ImageView img_tk_home,img_tk_datcho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_tai_khoan);

        logout = findViewById(R.id.tv_logout);
        img_tk_datcho = findViewById(R.id.img_tk_datcho);
        img_tk_home = findViewById(R.id.img_tk_home);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
                startActivity(i);
            }
        });


        img_tk_datcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DanhSachGiaoDich.class);
                startActivity(i);
            }
        });
        img_tk_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
                startActivity(i);
            }
        });


    }


}