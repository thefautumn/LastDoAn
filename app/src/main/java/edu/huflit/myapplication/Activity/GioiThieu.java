package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class GioiThieu extends AppCompatActivity {

    ImageView next_man_hinh_chinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next_man_hinh_chinh = (ImageView) findViewById(R.id.img_gioi_thieu);

        next_man_hinh_chinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TrangChu.class);
                startActivity(i);
            }
        });

    }
}