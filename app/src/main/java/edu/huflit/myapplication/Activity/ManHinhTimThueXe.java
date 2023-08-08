package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class ManHinhTimThueXe extends AppCompatActivity {

    Button btn_tim_xe;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_tim_thue_xe);
        anhXa();
        btn_tim_xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DanhSachXe.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TrangChu.class);
                startActivity(i);
            }
        });
    }
    public void anhXa()
    {
        btn_tim_xe = (Button) findViewById(R.id.btn_tim_xe);
        back = findViewById(R.id.img_trangchu);
    }
}