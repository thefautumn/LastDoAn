package edu.huflit.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import edu.huflit.myapplication.Models.HomeTour;
import edu.huflit.myapplication.Models.TTKhachHang;
import edu.huflit.myapplication.Models.User;
import edu.huflit.myapplication.R;

public class ManHinhDatTour extends AppCompatActivity {

    Button next_thanh_toan, btn_themTT;
    ImageView imgBack;
    TextView tvEmail;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dat_tour);
        anhXa();
        next_thanh_toan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_tt = new Intent(getApplicationContext(), ManHinhThanhToan.class);
                startActivity(next_tt);
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_ttlh = new Intent(getApplicationContext(), TrangChu.class);
                startActivity(next_ttlh);
            }
        });
        btn_themTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), ThemThongTinLienHe.class);
                startActivity(i);
            }
        });




    }
    public void anhXa()
    {
        btn_themTT =  findViewById(R.id.btn_themTT);
        next_thanh_toan =  findViewById(R.id.next_thanh_toan);
        imgBack = findViewById(R.id.imgBack_DatTour);
        tvEmail = findViewById(R.id.tv_Email_datcho);

        db = FirebaseFirestore.getInstance();

    }

}