package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class ChonDiemDonXe extends AppCompatActivity {

    Button next_thong_tin_dat_xe;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_diem_don_xe);
        anhXa();
        next_thong_tin_dat_xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ThongTinDatXe.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DanhSachXe.class);
                startActivity(i);
            }
        });
    }
    public void anhXa()
    {
        next_thong_tin_dat_xe = (Button) findViewById(R.id.next_thong_tin_dat_xe);
        back = findViewById(R.id.tv_back_chonxe);
    }
}