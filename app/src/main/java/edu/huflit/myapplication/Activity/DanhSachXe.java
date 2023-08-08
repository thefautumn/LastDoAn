package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
 import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class DanhSachXe extends AppCompatActivity {

    //Click vào ảnh xe để đến màn hình chọn điểm đón xe
    ImageView image_car, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_xe);
        anhXa();
        image_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ChonDiemDonXe.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ManHinhTimThueXe.class);
                startActivity(i);
            }
        });
    }
    public void anhXa()
    {
        image_car = (ImageView) findViewById(R.id.image_car);
        back = findViewById(R.id.img_back_Ds);
    }
}