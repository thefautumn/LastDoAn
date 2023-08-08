package edu.huflit.myapplication.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import edu.huflit.myapplication.Models.HomeTour;
import edu.huflit.myapplication.R;

public class ThemThongTinLienHe extends AppCompatActivity {
     FirebaseFirestore db;
    FirebaseUser user;
    ProgressDialog progressDialog;
    Button btnThem;
    EditText edtTen,edtEmail,edtSDT,edtDiachi;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thong_tin_lien_he);

        btnThem = findViewById(R.id.btn_Them);
        edtTen = findViewById(R.id.edt_Hoten);
        edtEmail = findViewById(R.id.edt_Email);
        edtSDT = findViewById(R.id.edt_SDT);
        edtDiachi = findViewById(R.id.edt_Diachi);
        imgBack = findViewById(R.id.img_back_ttlh);

        db = FirebaseFirestore.getInstance();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                int SDT = Integer.parseInt(edtSDT.getText().toString().trim());
                String DiaChi= edtDiachi.getText().toString().trim();
                UploadData(ten,email,DiaChi,SDT);
                Intent intent = new Intent(getApplicationContext(),ManHinhDatTour.class);
                startActivity(intent);

            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ManHinhDatTour.class);
                startActivity(i);
            }
        });

    }
    public  void UploadData(String ten, String email, String Diachi, int SDT){

        Map<String, Object> doc = new HashMap<>();
        doc.put("ten",ten);
        doc.put("email",email);
        doc.put("sdt",SDT);
        doc.put("dia_chi",Diachi);
        db.collection("KhachHang").document(email).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ThemThongTinLienHe.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ThemThongTinLienHe.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}