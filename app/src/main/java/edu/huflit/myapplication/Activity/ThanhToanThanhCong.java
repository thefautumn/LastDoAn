package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.huflit.myapplication.R;

public class ThanhToanThanhCong extends AppCompatActivity {

    Button btnQuayve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_thanh_cong);

        btnQuayve = findViewById(R.id.btn_quayvehome);

        btnQuayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrangChu.class);
                startActivity(i);
            }
        });
    }
}